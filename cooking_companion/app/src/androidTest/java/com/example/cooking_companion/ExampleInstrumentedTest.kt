import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.assertIsDisplayed
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cooking_companion.CompanionApp
import com.example.cooking_companion.MainActivity
import com.example.cooking_companion.ui.theme.Cooking_companionTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomNavbarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


}
