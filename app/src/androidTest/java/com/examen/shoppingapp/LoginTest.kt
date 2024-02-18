package com.examen.shoppingapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.examen.shoppingapp.databinding.ActivityLoginBinding
import com.examen.shoppingapp.view.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    lateinit var activityLoginBinding:ActivityLoginBinding

    @Test
    fun testEmptyUsernameAndPassword(){
        val usernameEditText = onView(withId(R.id.login_username))
        val passwordEditText = onView(withId(R.id.login_password))

        // Click login button
        val loginButton = onView(withId(R.id.login_button))
        loginButton.perform(click())

        // Assert on error message for empty username or password
        // Example:
        val errorTextView = onView(withId(R.id.constraint_login))
        errorTextView.check(matches(isDisplayed()))
        errorTextView.check(matches(withText("Username and password cannot be empty")))

    }
}