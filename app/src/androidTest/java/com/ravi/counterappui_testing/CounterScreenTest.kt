package com.ravi.counterappui_testing

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class CounterScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun counter_incremented_when_button_clicked() {
        // Verify initial count is 0
        composeTestRule
            .onNodeWithTag("counter_text")
            .assertTextEquals("Count: 0")

        // Click the increment button
        composeTestRule
            .onNodeWithTag("increment_button")
            .performClick()

        // Verify the count is now 1
        composeTestRule
            .onNodeWithTag("counter_text")
            .assertTextEquals("Count: 1")
    }

    @Test
    fun initial_ui_elements_displayed_correctly() {
        // Check Counter Text is displayed
        composeTestRule
            .onNodeWithTag("counter_text")
            .assertIsDisplayed()
            .assertTextEquals("Count: 0")

        // Check Increment Button is displayed
        composeTestRule
            .onNodeWithTag("increment_button")
            .assertIsDisplayed()
    }

    @Test
    fun clicking_increment_button_multiple_times_updates_counter() {
        repeat(5) {
            composeTestRule.onNodeWithTag("increment_button").performClick()
        }

        composeTestRule
            .onNodeWithTag("counter_text")
            .assertTextEquals("Count: 5")
    }

    @Test
    fun counter_should_not_decrease() {
        composeTestRule.onNodeWithTag("increment_button").performClick()

        composeTestRule.onNodeWithTag("counter_text")
            .assert(hasTextExactly("Count: 1")) // after one click, must be 1, not -1
    }


    @Test
    fun increment_button_is_clickable_and_enabled() {
        composeTestRule
            .onNodeWithTag("increment_button")
            .assertIsEnabled()
            .assertHasClickAction()
    }

}
