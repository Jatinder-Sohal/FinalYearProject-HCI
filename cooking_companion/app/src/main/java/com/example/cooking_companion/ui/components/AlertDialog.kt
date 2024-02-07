package com.example.cooking_companion.ui.components



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AddItemDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
    modifier : Modifier = Modifier
) {
    if (showDialog) {
        var newItemName by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Add New Item",
                    modifier = modifier.padding(start=5.dp)
                )
            },
            text = {
                TextField(
                    value = newItemName,
                    onValueChange = { newItemName = it },
                    label = { Text("Item Name") }
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (newItemName.isNotBlank()) {
                            onConfirm(newItemName)
                            newItemName = ""
                            onDismiss()
                        }
                    }
                ) { Text("Add") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}
@Composable
fun DeleteItemsDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier : Modifier = Modifier
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            icon = {
                Icon(Icons.Default.Warning, contentDescription = "Example Icon")
            },
            title = {
                Text(text = "Warning")
            },
            text = {
                Text(
                    text = "This will delete all your list items",
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { onConfirm(); onDismiss() }
                ) { Text("Delete") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}