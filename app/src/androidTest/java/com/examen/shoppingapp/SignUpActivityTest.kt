package com.examen.shoppingapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.examen.shoppingapp.view.SignUpActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class SignUpActivityTest {
    private val username = "johnd"
    private val password = "m38rmF$"
    private val invalidUsername = "invalid1234"
    private val incorrectPassword = "invalid1234"
    @Rule
    @JvmField
    val activitysignup = ActivityScenarioRule(SignUpActivity::class.java)

    @Before
    fun initSignup(){

    }
    //check the textview visibility and check display of text.
    @Test
    fun textVisibility_textView(){
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView2)).check(matches(isDisplayed()))
        onView(withId(R.id.register_signin)).check(matches(isDisplayed()))
    }
    //check the edittext visibility and hint text
    @Test
    fun editVisibility_editText(){
        onView(withId(R.id.register_username)).check(matches(isDisplayed()))
        onView(withId(R.id.register_password)).check(matches(isDisplayed()))
    }
    // check the button visibility and text
    @Test
    fun buttonVisibility_buttonText(){
        onView(withId(R.id.register_button)).check(matches(isDisplayed()))
    }
    // check edittext empty test case
    @Test
    fun testEmptyUsernameAndPassword(){
        onView(withId(R.id.register_username)).perform(ViewActions.typeText(""))
        onView(withId(R.id.register_password)).perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard())

        val loginButton = onView(withId(R.id.register_button))
        loginButton.perform(ViewActions.click())
        onView(withText("Username and password cannot be blank"))
            .check(matches(isDisplayed()))
    }
    // check the invalidate user name and password test case with validation
    @Test
    fun testLoginWithInvalidCredentials() {
        onView(withId(R.id.register_username)).perform(ViewActions.typeText(invalidUsername))
        onView(withId(R.id.register_password)).perform(
            ViewActions.typeText(incorrectPassword),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.register_button)).perform(ViewActions.click())
        //Assert that validation text should be displayed
        onView(withText("username or password is incorrect"))
    }
    @Test
    fun testLoginWithValidCredentials() {
        // Enter username
        onView(withId(R.id.register_username))
            .perform(ViewActions.typeText(username))

        // Enter password
        onView(withId(R.id.register_password))
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())

        // Click the login button
        onView(withId(R.id.register_button))
            .perform(ViewActions.click())

        // Assert that the progress bar is displayed
        onView(withId(R.id.register_progress))
            .check(matches(isDisplayed()))
    }
    @After
    fun cleanUp(){

    }
}