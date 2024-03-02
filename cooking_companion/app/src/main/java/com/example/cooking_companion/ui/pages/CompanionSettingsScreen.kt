package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.data.DataSource.darkMode

@Composable
fun CompanionSettingsScreen(
    modifier: Modifier = Modifier,
) {
    val notificationsEnabled = remember { mutableStateOf(true) }
    val darkThemeEnabled = remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(16.dp)) {
        ListItem(
            headlineContent = { Text("Notifications") },
            trailingContent = {
                Switch(
                    checked = notificationsEnabled.value,
                    onCheckedChange = { notificationsEnabled.value = it }
                )
            }
        )
        Divider()

        ListItem(
            headlineContent = { Text("Dark Theme") },
            trailingContent = {
                Switch(
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkMode.value =  true; darkThemeEnabled.value = it }
                )
            }
        )
        Divider()

    }
}