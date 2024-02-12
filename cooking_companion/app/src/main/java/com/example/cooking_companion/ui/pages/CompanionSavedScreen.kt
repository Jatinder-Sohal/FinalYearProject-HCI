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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Collection
import com.example.cooking_companion.ui.components.AddNewCollection
import com.example.cooking_companion.ui.components.CollectionOption


@Composable
fun CompanionSavedScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var collections by remember { mutableStateOf(listOf(
        Collection("List1", 0),
        Collection("List2", 0),
        Collection("List3", 0),
        Collection("List4", 0),

    ))}
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Text(
            text = "Saved Collections",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 35.sp,
            modifier = modifier
                .padding(16.dp)
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
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    AddNewCollection(
                        onClick = {
                            val newCollection = Collection("New", 0)
                            collections = collections + newCollection
                        }
                    )
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
                                val newCollection = Collection("New", 0)
                                collections = collections + newCollection
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }

                }
            }
        }
    }
}



