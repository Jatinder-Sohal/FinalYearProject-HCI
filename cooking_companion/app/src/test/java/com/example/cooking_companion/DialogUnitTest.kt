import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import com.example.cooking_companion.ui.components.OneInputDialog
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test


class OneInputDialogTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun oneInputDialog_Displayed_Correctly() {
        var wasConfirmed = false
        val testInput = "New Item"

        composeTestRule.setContent {
            OneInputDialog(
                title = "Add Item",
                boxTitle = "Item Name",
                showDialog = true,
                onDismiss = {},
                onConfirm = {
                    wasConfirmed = it == testInput
                }
            )
        }
        composeTestRule.onNodeWithText("Add Item").assertIsDisplayed()
        composeTestRule.onNodeWithText("Item Name").assertIsDisplayed()
        composeTestRule.onNodeWithText("Add").performClick()
        assertTrue(wasConfirmed)
    }
    @Test
    fun oneInputDialog_EmptyInput() {
        var wasConfirmed = false

        composeTestRule.setContent {
            OneInputDialog(
                title = "Add Item",
                boxTitle = "Item Name",
                showDialog = true,
                onDismiss = {},
                onConfirm = {
                    wasConfirmed = true
                }
            )
        }
        composeTestRule.onNodeWithText("Add").performClick()
        assertFalse("The dialog should not confirm when input is empty.", wasConfirmed)
    }
    @Test
    fun oneInputDialog_Dismiss_Functioning() {
        var wasDismissed = false

        composeTestRule.setContent {
            OneInputDialog(
                title = "Add Item",
                boxTitle = "Item Name",
                showDialog = true,
                onDismiss = { wasDismissed = true },
                onConfirm = {}
            )
        }
        composeTestRule.onNodeWithText("Cancel").performClick()
        assertTrue( "The dialog should dismiss when cancel is clicked.", wasDismissed)
    }
}
