package com.examen.shoppingapp




import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.examen.shoppingapp.view.LoginActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {
    private val username = "johnd"
    private val password = "m38rmF$"

    private val invalidUsername = "invalid1234"
    private val incorrectPassword = "invalid1234"
    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Before
    fun initUI(){

    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.examen.shoppingapp", appContext.packageName)
    }

    //visibility of textview text or name
    @Test
    fun testVisibility_textView(){

        onView(withId(R.id.textView))
            .check(matches(isDisplayed())) // method 1

        onView(withId(R.id.textView2))
            .check(matches(isDisplayed()))

        onView(withId(R.id.login_signup))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textView3))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textView))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // method 2

    }

    //visibility of button and set name on button
    @Test
    fun testVisibility_button(){
        onView(withId(R.id.login_signup))
            .check(matches(isDisplayed()))

    }
    //visibility of edittext and set name on button
    @Test
    fun testVisibility_editText(){
        onView(withId(R.id.login_username))
            .check(matches(isDisplayed()))

        onView(withId(R.id.login_password))
            .check(matches(isDisplayed()))
    }
    // check the empty validation for login
    @Test
    fun testEmptyUsernameAndPassword(){

        onView(withId(R.id.login_username)).perform(typeText(""))
        onView(withId(R.id.login_password)).perform(typeText(""),closeSoftKeyboard())
        // Click login button
        val loginButton = onView(withId(R.id.login_button))
        loginButton.perform(click())

        // Assert on error message for empty username or password
        // Example:
        /*onView(withText("Username and password cannot be blank"))
            .check(matches(isDisplayed()))*/
        val errorTextView = onView(withId(R.id.textView_error))
        errorTextView.check(matches(isDisplayed()))
        errorTextView.check(matches(withText("Username and password cannot be blank")))
    }

    // invalid user name and password test case
    @Test
    fun testLoginWithInvalidCredentials(){
        //enter wrong user name
        onView(withId(R.id.login_username)).perform(typeText(invalidUsername))
        // enter wrong password
        onView(withId(R.id.login_password)).perform(typeText(incorrectPassword),closeSoftKeyboard())
        // Click the login button
        onView(withId(R.id.login_button)).perform(click())
        //Assert that validation text should be displayed
        onView(withText("username or password is incorrect"))
            .check(matches(isDisplayed()))
        /*val errorTextView = onView(withId(R.id.constraint_login))
        errorTextView.check(matches(isDisplayed()))
        errorTextView.check(matches(withText("username or password is incorrect")))
 */   }

   // valid login test case
    @Test
    fun testLoginWithValidCredentials(){
        // Enter username
        onView(withId(R.id.login_username))
            .perform(typeText(username))

        // Enter password
        onView(withId(R.id.login_password))
            .perform(typeText(password), closeSoftKeyboard())

        // Click the login button
        onView(withId(R.id.login_button))
            .perform(click())

        // Assert that the progress bar is displayed
        onView(withId(R.id.login_progress))
            .check(matches(isDisplayed()))
        //assertion
        /*val errorTextView = onView(withId(R.id.constraint_login))
        errorTextView.check(matches(isDisplayed()))
        errorTextView.check(matches(withText("Login is successfully")))*/


    }


    @After
    fun cleanUp(){

    }
}

