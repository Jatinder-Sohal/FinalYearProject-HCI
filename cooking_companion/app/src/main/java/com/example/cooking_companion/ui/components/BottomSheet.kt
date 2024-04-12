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

/**
 * Displays a list of selectable options for lists.
 * This sheet allows the user to select one of the predefined lists or add a new one.
 *
 * @param onListSelected Function that handles the event when a list is selected.
 * @param onAddList Function that handles the event when the 'Add New List' button is clicked.
 */
@Composable
fun SelectListsSheet(onListSelected: (String) -> Unit, onAddList: () -> Unit) {
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
/**
 * Displays a list of selectable options for collections.
 *
 * This sheet allows the user to select one of the predefined collections.
 * Used to manage user-defined collections of recipes or data.
 *
 * @param onCollectionSelected Function that handles the event when a collection is selected.
 */
@Composable
fun SelectCollectionSheet(onCollectionSelected: () -> Unit) {
    val items = listOf("Collection one", "16/12/23", "List 5")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 32.dp)
    ) {
        Text(
            text = "Select a Collection",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        items.forEach { item ->
            TextButton(
                onClick = { onCollectionSelected() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(item)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
/**
 * Displays a sheet with selectable filters for saved items.
 *
 * Users can filter saved content based on the provided options.
 * Each filter option is represented by a radio button.
 *
 * @param title The title of the filter sheet.
 * @param filterOptions List of filter options available.
 * @param currentFilter The currently selected filter option.
 * @param onFilterSelected Function that handles the event when a filter is selected.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
@Composable
fun SavedFiltersSheet(title:String, filterOptions: List<String>, currentFilter: String, onFilterSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(bottom = 35.dp)

    ){
        Text(
            text = title,
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
