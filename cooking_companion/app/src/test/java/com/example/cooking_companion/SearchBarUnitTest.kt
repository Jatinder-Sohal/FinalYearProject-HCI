import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.cooking_companion.ui.components.TopSearchBar
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test


class TopSearchBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Composable
    @Test
    fun topSearchBar_Rendering_Correctly() {
        val navController = rememberNavController()

        composeTestRule.setContent {
            TopSearchBar(navController)
        }

        composeTestRule.onNodeWithContentDescription("Search Icon").assertExists("Search icon should be visible")
        composeTestRule.onNodeWithText("Search for recipes").assertExists("Placeholder text should be visible")
    }

    @Composable
    @Test
    fun topSearchBar_Options_Click() {
        val navController = rememberNavController()

        composeTestRule.setContent {
            TopSearchBar(navController)
        }

        composeTestRule.onNodeWithContentDescription("Expand Options").performClick()
        composeTestRule.onNodeWithText("Option 1").assertExists("Dropdown options should be visible after click")
    }
    @Composable
    @Test
    fun topSearchBar_ContentDescriptions() {
        val navController = rememberNavController()

        composeTestRule.setContent {
            TopSearchBar(navController)
        }

        composeTestRule.onNodeWithContentDescription("Search Icon").assertExists("Search icon should have a content description")
    }
}
