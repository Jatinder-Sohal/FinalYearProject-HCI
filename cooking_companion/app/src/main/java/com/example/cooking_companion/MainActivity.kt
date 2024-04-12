package com.example.cooking_companion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cooking_companion.ui.theme.Cooking_companionTheme

/**
 * Main activity for the Cooking Companion application.
 *
 * This activity serves as the entry point for the application. It sets up the app's theme and displays the main app component.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     * shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cooking_companionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CompanionApp()
                }
            }
        }
    }
}