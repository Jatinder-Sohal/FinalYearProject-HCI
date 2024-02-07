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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.ui.components.AddItemDialog
import com.example.cooking_companion.ui.components.DeleteItemsDialog
import com.example.cooking_companion.ui.components.Dropdown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanionListsScreen(modifier: Modifier = Modifier) {
    var listOneItems by remember { mutableStateOf(listOf("Milk", "Eggs", "Bread", "Bread","Bread")) }
    var listTwoItems by remember { mutableStateOf(listOf("Milk")) }
    var listOneExpanded by remember { mutableStateOf(false) }
    var listTwoExpanded by remember { mutableStateOf(false) }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val scrollState = rememberScrollState()

    var showAddNewItem by remember { mutableStateOf(false) }
    var showDeleteWarning by remember { mutableStateOf(false) }
    AddItemDialog(
        showDialog = showAddNewItem,
        onDismiss = { showAddNewItem = false },
        onConfirm = { newItem ->
            listOneItems = listOneItems + newItem
        },
    )
    DeleteItemsDialog(
        showDialog = showDeleteWarning,
        onDismiss = { showDeleteWarning = false },
        onConfirm = { listOneItems = listOf(); listTwoItems = listOf() },
    )
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                title = {
                    Text(
                        "Shopping list",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Load all lists"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteWarning = true}) {
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
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(innerPadding),

            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Dropdown(
                items = listOneItems,
                title = "To buy",
                expanded = listOneExpanded,
                toggleDropdown = { listOneExpanded = !listOneExpanded },
                moveItem = { item ->
                    listOneItems = listOneItems - item
                    listTwoItems = listTwoItems + item
                },
                deleteItem = { item ->
                    listOneItems = listOneItems - item
                },
                checked = false
            )
            Dropdown(
                items = listTwoItems,
                title =  "Bought",
                expanded = listTwoExpanded,
                toggleDropdown = { listTwoExpanded = !listTwoExpanded },
                moveItem = { item ->
                    listOneItems = listOneItems + item
                    listTwoItems = listTwoItems - item
                },
                deleteItem = { item ->
                    listTwoItems = listTwoItems - item
                },
                checked = true
            )
        }
    }
}
