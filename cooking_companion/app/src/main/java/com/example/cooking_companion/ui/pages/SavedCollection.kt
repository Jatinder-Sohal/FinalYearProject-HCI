package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Bookmark
import com.example.cooking_companion.data.Collection
import com.example.cooking_companion.data.DataSource
import com.example.cooking_companion.data.DataSource.collections
import com.example.cooking_companion.ui.components.CollectionItem
import com.example.cooking_companion.ui.components.DeleteItemsDialog
import com.example.cooking_companion.ui.components.OneInputDialog
import com.example.cooking_companion.ui.components.SavedFiltersSheet


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedCollection(navController: NavHostController, collectionPosts: String, modifier: Modifier = Modifier) {
    var currentFilter by remember { mutableStateOf("A to Z") }
    val filterOptions = listOf("A to Z", "Difficulty", "Quickest", "Slowest")
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    val posts = collectionPosts.toInt()
    val (bookmarkedRecipes, setBookmarkedRecipes) = remember { mutableStateOf(filterRecipes(currentFilter, DataSource.bookmarkedRecipes.subList(0, posts)))}
    val onBookmarkClick = { bookmark: Bookmark ->
        setBookmarkedRecipes(bookmarkedRecipes.filter { it.id != bookmark.id })
    }
    val scrollState = rememberScrollState()
    var title = when (collectionPosts){
        "9" -> "Collection One"
        "2" -> "12/02/24"
        "1" -> "List3"
        else -> {"New List"}
    }

    var showDeleteWarning by remember { mutableStateOf(false) }
    var showChangeTitle by remember { mutableStateOf(false) }
    DeleteItemsDialog(
        text = "This will delete your collection of recipes",
        showDialog = showDeleteWarning,
        onDismiss = { showDeleteWarning = false },
        onConfirm = {
            collections.removeIf { it.posts == posts }
            navController.popBackStack()
        },
    )
    OneInputDialog(
        title = "Change Collection Title",
        boxTitle = "New title",
        showDialog = showChangeTitle,
        onDismiss = { showChangeTitle = false },
        onConfirm = { newName ->
            collections.removeIf { it.posts == posts }
            val newCollection = Collection(newName, posts, listOf())
            collections.add(newCollection)
            title = newName
        },
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                title = {
                    Text(
                        title,
                        fontSize = 24.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back to main collections page"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { showChangeTitle = true}) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteWarning = true}) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete All")
                    }
                },
            )
        },
    ) { innerPadding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ){
                        Text(
                            text = "Recipes",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Medium,
                            modifier = modifier
                                .padding(horizontal = 32.dp, vertical = 0.dp)
                                .padding(top=4.dp)
                        )
                        Row(
                            modifier = Modifier
                                .width(150.dp)
                                .padding(top = 4.dp, end = 32.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            IconButton(
                                onClick = { showBottomSheet = true },
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row{
                                    Text(
                                        text = currentFilter,
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier.weight(1f),
                                        maxLines = 1,
                                        textAlign = TextAlign.End
                                    )
                                    Icon(
                                        Icons.Filled.KeyboardArrowDown,
                                        contentDescription = "Delete All"
                                    )
                                }
                            }
                        }
                    }
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = { showBottomSheet = false },
                            sheetState = sheetState
                        ) {
                            SavedFiltersSheet(
                                filterOptions = filterOptions,
                                currentFilter = currentFilter,
                                onFilterSelected = {filter ->
                                    currentFilter = filter
                                    showBottomSheet=false
                                    setBookmarkedRecipes(filterRecipes(currentFilter, DataSource.bookmarkedRecipes))
                                }
                            )
                        }
                    }
                    for (bookmark in bookmarkedRecipes) {
                        if (bookmark.isBookmarked) {
                            CollectionItem(bookmark, onBookmarkClick = { onBookmarkClick(bookmark) })
                        }
                    }
                }
            }
        }
    }
}
fun filterRecipes(filterOption: String, recipes: List<Bookmark>): List<Bookmark> {
    val difficultyOrder = listOf("Easy", "Moderate", "Hard")
    return when (filterOption) {
        "Difficulty" -> recipes.sortedBy { recipe ->
            difficultyOrder.indexOf(recipe.difficulty)}
        "Quickest" -> recipes.sortedBy { it.id }
        "Longest" -> recipes.sortedByDescending { it.id }
        else -> recipes
    }
}
