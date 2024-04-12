import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.cooking_companion.MainActivity
import com.example.cooking_companion.R
import com.example.cooking_companion.data.Recipe
import com.example.cooking_companion.ui.components.RecipeCard
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

class RecipeCardTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Composable
    @Test
    fun recipeCard_NavigationClick() {
        val navController = rememberNavController()
        val recipe = Recipe("Vegan Curry", R.drawable.chickencurry_dishes, false, 87, "Arjun Dhoot")

        composeTestRule.setContent {
            RecipeCard(recipe, navController, "originList")
        }

        composeTestRule.onNodeWithContentDescription("Recipe Card").performClick()
        assertEquals("Expected navigation did not occur.", "Recipe/${recipe.name}/originList", navController.currentDestination?.route)
    }
    @Test
    fun recipeCard_BookmarkToggle() {
        val recipe = Recipe("Vegan Curry", R.drawable.chickencurry_dishes, false, 87, "Arjun Dhoot")
        var bookmarked = recipe.bookmarked

        composeTestRule.setContent {
            RecipeCard(recipe, rememberNavController(), "originList")
        }

        composeTestRule.onNodeWithContentDescription("Save recipe").performClick()
        assertTrue("Bookmark should be set.", bookmarked)


        composeTestRule.onNodeWithContentDescription("Save recipe").performClick()
        assertFalse("Bookmark should be unset.", bookmarked)
    }

}
