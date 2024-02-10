package com.example.cooking_companion.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListsBottomSheet(onListSelected: (String) -> Unit, onAddList: () -> Unit) {
    val items = listOf("List 1", "List 2", "List 3")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 32.dp)
    ) {
        Text(
            text = "Select a List",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        items.forEach { item ->
            TextButton(
                onClick = { onListSelected(item) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(item)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onAddList,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add List")
            Text("Add New List")
        }
    }
}
@Composable
fun SavedFiltersSheet(filterOptions: List<String>, currentFilter: String, onFilterSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(bottom = 35.dp)

    ){
        Text(
            text = "Sort Saved Recipes by",
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier.padding(start = 16.dp, bottom = 16.dp)
        )
        Divider()
        filterOptions.forEach { filter ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(bottom = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = currentFilter == filter,
                    onClick = {onFilterSelected(filter)}
                )
                Text(
                    text = filter,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(start = 16.dp)
                )
            }
        }
    }

}
