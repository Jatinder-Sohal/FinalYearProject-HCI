import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import com.example.cooking_companion.ui.components.SelectListsSheet
import org.junit.Rule
import org.junit.Test

class SelectListsSheetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun selectListsSheet_Renders_Correctly() {
        val items = listOf("List 1", "List 2", "List 3")
        var selectedItem = ""

        composeTestRule.setContent {
            SelectListsSheet(
                onListSelected = { selectedItem = it },
                onAddList = {}
            )
        }
        items.forEach { item ->
            composeTestRule.onNodeWithText(item).assertIsDisplayed().performClick()
            assert(selectedItem == item)
        }
    }

    @Test
    fun selectListsSheet_NewListButton_Functionality() {
        var addListClicked = false

        composeTestRule.setContent {
            SelectListsSheet(
                onListSelected = {},
                onAddList = { addListClicked = true }
            )
        }
        composeTestRule.onNodeWithText("Add New List").performClick()
        assert(addListClicked)
    }
}