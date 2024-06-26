package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Collection
import com.example.cooking_companion.data.DataSource
import com.example.cooking_companion.ui.components.AddNewCollection
import com.example.cooking_companion.ui.components.CollectionOption

/**
 * Displays a navigational view for saved collections of recipes, allowing users to view and manage collections.
 *
 * This page includes a list of saved collections presented in a LazyColumn, where each collection
 * can be viewed or edited. It also provides an option to add a new collection directly from this page.
 *
 * @param navController The navigation controller for handling navigation events, facilitating movement between UI components.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
@Composable
fun NavbarSaved(navController: NavHostController, modifier: Modifier = Modifier) {
    val collections = DataSource.collections
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Text(
            text = "Saved Collections",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 37.sp,
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 14.dp)
                .padding(top = 20.dp)
                .align(Alignment.Start)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            items(collections.chunked(2)) { chunk ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    chunk.forEach { collection ->
                        CollectionOption(collection, navController)
                    }
                    if (collections.size % 2 != 0 && chunk == collections.chunked(2).last()) {
                        AddNewCollection(
                            onClick = {
                                val newCollection = Collection("New List", 0, listOf())
                                collections.add(newCollection)
                            }
                        )
                    }

                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    if (collections.size % 2 == 0) {
                        AddNewCollection(
                            onClick = {
                                val newCollection = Collection("New", 0, listOf())
                                collections.add(newCollection)
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }

                }
            }
        }
    }
}



