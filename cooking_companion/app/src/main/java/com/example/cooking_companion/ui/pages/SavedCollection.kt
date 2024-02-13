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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.cooking_companion.data.Bookmark
import com.example.cooking_companion.data.DataSource
import com.example.cooking_companion.ui.components.CollectionItem
import com.example.cooking_companion.ui.components.SavedFiltersSheet


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedCollection(modifier: Modifier = Modifier, collectionPosts: String) {
    var currentFilter by remember { mutableStateOf("A to Z") }
    val filterOptions = listOf("A to Z", "Difficulty", "Quickest", "Slowest")
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    
    val (bookmarkedRecipes, setBookmarkedRecipes) = remember { mutableStateOf(filterRecipes(currentFilter, DataSource.bookmarkedRecipes.subList(0, collectionPosts.toInt())))}
    val onBookmarkClick = { bookmark: Bookmark ->
        setBookmarkedRecipes(bookmarkedRecipes.filter { it.id != bookmark.id })
    }
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                title = {
                    Text("")
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
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { }) {
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
                shape = MaterialTheme.shapes.medium,
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
