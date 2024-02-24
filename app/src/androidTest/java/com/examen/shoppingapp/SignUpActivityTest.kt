package com.examen.shoppingapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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

    @Rule
    @JvmField
    val activitysignup = ActivityScenarioRule(SignUpActivity::class.java)

    @Before
    fun  initSignup(){

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

    @After
    fun cleanUp(){

    }
}