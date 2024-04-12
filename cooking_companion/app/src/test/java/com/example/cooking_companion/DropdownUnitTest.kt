import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.cooking_companion.ui.components.Dropdown
import com.example.cooking_companion.ui.components.ListItem
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class DropdownTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dropdown_Toggles_Functioning() {
        var expanded = false
        val items = listOf("Item 1", "Item 2", "Item 3")

        composeTestRule.setContent {
            Dropdown(
                items = items,
                title = "Tap to Toggle",
                expanded = expanded,
                toggleDropdown = { expanded = !expanded },
                moveItem = {},
                deleteItem = {},
                checked = false
            )
        }
        composeTestRule.onNodeWithText("Tap to Toggle").performClick()
        items.forEach { item ->
            composeTestRule.onNodeWithText(item).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText("Tap to Toggle").performClick()
        items.forEach { item ->
            composeTestRule.onNodeWithText(item).assertIsNotDisplayed()
        }
    }

    @Test
    fun listItem_Delete_Functioning() {
        var deleted = false
        var moved = false
        val itemText = "Sample Item"

        composeTestRule.setContent {
            ListItem(
                text = itemText,
                moveItem = { moved = true },
                deleteItem = { deleted = true },
                checked = false
            )
        }
        composeTestRule.onNodeWithContentDescription("Delete").performClick()
        assertTrue("Delete action was not triggered", deleted)
    }
}
