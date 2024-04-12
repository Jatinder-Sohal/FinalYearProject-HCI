package com.example.cooking_companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Displays a dropdown list with selectable items. Each item can be moved or deleted.
 *
 * The dropdown can be toggled to show or hide its items with an expand/collapse functionality,
 * controlled by the expanded state. Items within the dropdown can be interacted with, including
 * moving and deleting actions.
 *
 * @param items The list of strings to be displayed in the dropdown.
 * @param title The title of the dropdown, displayed at the top.
 * @param expanded A boolean value indicating whether the dropdown is expanded or collapsed.
 * @param toggleDropdown A function invoked when the dropdown is clicked, toggling its open state.
 * @param moveItem A function to move an item, takes a string as input.
 * @param deleteItem A function to delete an item, takes a string as input.
 * @param checked A boolean state that represents whether an item is selected or not.
 */
@Composable
fun Dropdown(
    items: List<String>,
    title: String,
    expanded: Boolean,
    toggleDropdown: () -> Unit,
    moveItem:(String) -> Unit,
    deleteItem:(String) -> Unit,
    checked : Boolean
) {
    Column {
        Row(
            modifier = Modifier
                .clickable(onClick = toggleDropdown)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Toggle Dropdown"
            )
        }
        if (expanded) {
            items.forEach { item ->
                ListItem(text = item, {moveItem(item)}, {deleteItem(item)}, checked)
            }
        }
    }
}

/**
 * Represents an item within a list, including interaction features such as move and delete.
 *
 * This composable function displays a single item from the dropdown, with options to select,
 * move, or delete the item.
 *
 * @param text The text to display for this item.
 * @param moveItem A callback function to be invoked when the move action is triggered.
 * @param deleteItem A callback function to be invoked when the delete action is triggered.
 * @param checked The current selection state of the item.
 * @param modifier Modifier passed to adjust the styling or layout of the row item.
 */
@Composable
fun ListItem(
    text: String,
    moveItem: () -> Unit,
    deleteItem: () -> Unit,
    checked: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { moveItem() }
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { deleteItem() }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}