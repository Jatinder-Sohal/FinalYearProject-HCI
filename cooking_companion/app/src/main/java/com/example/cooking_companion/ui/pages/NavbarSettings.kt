package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.DataSource.darkMode
import com.example.cooking_companion.data.DataSource.headerFont
import com.example.cooking_companion.data.DataSource.settingFont

@Composable
fun NavbarSettings(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val notificationsEnabled = remember { mutableStateOf(true) }
    var darkThemeEnabled = remember { mutableStateOf(darkMode.value) }
    val contrastEnabled = remember { mutableStateOf(false) }
    val enlargeTextEnabled = remember { mutableStateOf(false) }
    val hText = remember { mutableIntStateOf(headerFont.intValue) }
    val titleText = remember { mutableIntStateOf(37) }

    if (contrastEnabled.value){
        darkThemeEnabled.value = false;
        darkMode.value = true;
    }else{
        darkMode.value = false;
        darkThemeEnabled = remember { mutableStateOf(darkMode.value) }
    }
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.titleLarge,
            fontSize = titleText.intValue.sp,
            modifier = modifier
                .padding(horizontal = 4.dp, vertical = 10.dp)
                .padding(top = 20.dp)
                .align(Alignment.Start)
        )
        Divider()
        Text(
            text = "System",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            fontSize = hText.intValue.sp,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 1.dp)
                .padding(top = 15.dp)
                .align(Alignment.Start)
        )

        ListItem(
            headlineContent = { Text("Notifications", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = notificationsEnabled.value,
                    onCheckedChange = { notificationsEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }

                )

            }
        )
        ListItem(
            headlineContent = { Text("Dark Theme", fontSize=settingFont.intValue.sp)},
            trailingContent = {
                Switch(
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkMode.value =  !darkMode.value; darkThemeEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )

        Divider()
        Text(
            text = "Accessibility",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            fontSize = headerFont.intValue.sp,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 1.dp)
                .padding(top = 15.dp)
                .align(Alignment.Start)
        )
        ListItem(
            headlineContent = { Text("Enlarged Text", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = enlargeTextEnabled.value,
                    onCheckedChange = {
                        enlargeTextEnabled.value = it
                        if (it) {
                            hText.intValue = 26
                            settingFont.intValue = 20
                            titleText.intValue = 45
                        } else {
                            hText.intValue = 20
                            settingFont.intValue = 16
                            titleText.intValue = 37
                        }
                        headerFont.intValue = hText.intValue
                    },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )
        ListItem(
            headlineContent = { Text("Contrast mode", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = contrastEnabled.value,
                    onCheckedChange = { contrastEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )
        Divider()
        Text(
            text = "Customization",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            fontSize = headerFont.intValue.sp,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 1.dp)
                .padding(top = 15.dp)
                .align(Alignment.Start)
        )
        ListItem(
            headlineContent = { Text("Theme", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkMode.value =  !darkMode.value; darkThemeEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )
        ListItem(
            headlineContent = { Text("Measurements", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkMode.value =  !darkMode.value; darkThemeEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )
        ListItem(
            headlineContent = { Text("Auto Servings", fontSize=settingFont.intValue.sp) },
            trailingContent = {
                Switch(
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkMode.value =  !darkMode.value; darkThemeEnabled.value = it },
                    colors = if (contrastEnabled.value){
                        SwitchDefaults.colors(
                            checkedThumbColor = Color.Yellow ,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    }else{
                        SwitchDefaults.colors()
                    }
                )
            }
        )
    }
}