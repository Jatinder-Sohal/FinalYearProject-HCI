package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.ui.components.ChangeTitles
import com.example.cooking_companion.ui.components.DeleteItemsDialog
import com.example.cooking_companion.ui.components.Dropdown
import com.example.cooking_companion.ui.components.OneInputDialog
import com.example.cooking_companion.ui.components.SelectListsSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanionListsScreen(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("Shopping List") }
    var listOneName by remember {mutableStateOf("To buy") }
    var listTwoName by remember {mutableStateOf("Bought") }
    var listOneItems by remember { mutableStateOf(listOf("Milk", "Eggs", "Bread", "Paprika", "Tomatoes")) }
    var listTwoItems by remember { mutableStateOf(listOf("Lemons")) }
    var listOneExpanded by remember { mutableStateOf(false) }
    var listTwoExpanded by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var showChangeTitle by remember { mutableStateOf(false) }
    var showAddNewItem by remember { mutableStateOf(false) }
    var showDeleteWarning by remember { mutableStateOf(false) }
    ChangeTitles(
        showDialog = showChangeTitle,
        onDismiss = { showChangeTitle = false },
        onConfirm = { updatedTitle, updatedDropDownOne, updatedDropDownTwo ->
            title = updatedTitle
            listOneName = updatedDropDownOne
            listTwoName = updatedDropDownTwo
        },
        originalTitle = title,
        originalDropDownOne = listOneName,
        originalDropDownTwo = listTwoName
    )
    OneInputDialog(
        title = "Add New Item",
        boxTitle = "Item Name",
        showDialog = showAddNewItem,
        onDismiss = { showAddNewItem = false },
        onConfirm = { newItem ->
            listOneItems = listOneItems + newItem
        },
    )
    DeleteItemsDialog(
        text = "This will delete all your list items",
        showDialog = showDeleteWarning,
        onDismiss = { showDeleteWarning = false },
        onConfirm = {
            listOneItems = listOf(); listTwoItems = listOf(); title =
            "Click pencil to enter a list name"
        },
    )

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val scrollState = rememberScrollState()

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                title = {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { showBottomSheet = true }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Load all lists"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { showChangeTitle = true }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteWarning = true }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete All")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddNewItem = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add item")
            }
        }
    ) { innerPadding ->
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                SelectListsSheet(
                    onListSelected = {
                        itemSelected -> title = itemSelected
                        showBottomSheet = false
                    },
                    onAddList = {
                        title = "Click pencil to enter a list name"
                        listOneName = ""
                        listTwoName = ""
                        listOneItems = (listOf())
                        listTwoItems = (listOf())
                        showBottomSheet=false
                    }
                )
            }
        }
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(innerPadding),

            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Dropdown(
                items = listOneItems,
                title = listOneName,
                expanded = listOneExpanded,
                toggleDropdown = { listOneExpanded = !listOneExpanded },
                moveItem = { item ->
                    listOneItems = listOneItems - item
                    listTwoItems = listTwoItems + item
                },
                deleteItem = {
                    item ->
                    listOneItems = listOneItems - item
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "$item has been deleted from the list",
                                actionLabel = "Undo",
                                duration = SnackbarDuration.Short
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                listOneItems = listOneItems + item
                            }
                            SnackbarResult.Dismissed -> {
                            }
                        }
                    }
                },
                checked = false
            )
            Dropdown(
                items = listTwoItems,
                title = listTwoName,
                expanded = listTwoExpanded,
                toggleDropdown = { listTwoExpanded = !listTwoExpanded },
                moveItem = { item ->
                    listOneItems = listOneItems + item
                    listTwoItems = listTwoItems - item
                },
                deleteItem = {
                    item ->
                    listTwoItems = listTwoItems - item
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "$item has been deleted from the list",
                                actionLabel = "Undo",
                                duration = SnackbarDuration.Short
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                listTwoItems = listTwoItems + item
                            }
                            SnackbarResult.Dismissed -> {
                            }
                        }
                    }
                },
                checked = true
            )
        }
    }
}
