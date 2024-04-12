package com.example.cooking_companion.ui.components



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Composable function that displays a dialog with a single text input field.
 * It allows users to input a new item's name and confirm or dismiss the dialog.
 *
 * @param title The title of the dialog.
 * @param boxTitle The label for the input field.
 * @param showDialog Controls the visibility of the dialog.
 * @param onDismiss Function to execute when the dialog is dismissed.
 * @param onConfirm Function to execute with the input text when confirmed.
 * @param modifier Modifier for styling the components within the dialog.
 */
@Composable
fun OneInputDialog(
    title: String,
    boxTitle: String,
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
                    text = title,
                    modifier = modifier.padding(start=5.dp)
                )
            },
            text = {
                TextField(
                    value = newItemName,
                    onValueChange = { newItemName = it },
                    label = { Text(boxTitle) }
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
/**
 * Composable function that displays a dialog with multiple text input fields for editing titles.
 * Used for changing the titles of lists and dropdown options.
 *
 * @param showDialog Controls the visibility of the dialog.
 * @param onDismiss Function to execute when the dialog is dismissed.
 * @param onConfirm Function to execute with the new titles when confirmed.
 * @param originalTitle Default value for the main title input field.
 * @param originalDropDownOne Default value for the first dropdown title input field.
 * @param originalDropDownTwo Default value for the second dropdown title input field.
 * @param modifier Modifier for styling the components within the dialog.
 */
@Composable
fun ChangeTitles(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String, String, String) -> Unit,
    originalTitle : String,
    originalDropDownOne : String,
    originalDropDownTwo : String,
    modifier : Modifier = Modifier
) {
    if (showDialog) {
        var title by remember { mutableStateOf(originalTitle) }
        var dropDownOne by remember { mutableStateOf(originalDropDownOne) }
        var dropDownTwo by remember { mutableStateOf(originalDropDownTwo) }

        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Edit titles",
                    modifier = modifier.padding(start=5.dp)
                )
            },

            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("List title") },
                        modifier = modifier.padding(bottom = 15.dp)
                    )
                    TextField(
                        value = dropDownOne,
                        onValueChange = { dropDownOne = it },
                        label = { Text("Drop Down One") },
                        modifier = modifier.padding(bottom = 15.dp)
                    )
                    TextField(
                        value = dropDownTwo,
                        onValueChange = { dropDownTwo = it },
                        label = { Text("Drop Down Two") }
                    )
                }
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm(title, dropDownOne, dropDownTwo)
                        onDismiss()
                    }
                ) { Text("Change") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}

/**
 * Composable function that displays a warning dialog for confirming item deletion.
 * Used to prevent any errors from users.
 *
 * @param text The text displayed inside the dialog to warn the user about the deletion.
 * @param showDialog Controls the visibility of the dialog.
 * @param onDismiss Function to execute when the dialog is dismissed without confirmation.
 * @param onConfirm Function to execute when the deletion is confirmed.
 * @param modifier Modifier for styling the components within the dialog.
 */
@Composable
fun DeleteItemsDialog(
    text: String,
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
                    text = text,
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