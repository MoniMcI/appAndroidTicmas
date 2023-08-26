package com.curso.android.app.miappticmas.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.curso.android.app.miappticmas.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testButtonClick() {
        // Simula hacer clic en un botón con ID "buttonId"
        Espresso.onView(
            ViewMatchers.withId(R.id.buttonComparar)
        ).perform(
            ViewActions.click()
        )

        // Verifica que el TextView tenga el texto esperado
        Espresso.onView(
            ViewMatchers.withId(R.id.textViewMensaje)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los números son iguales")
            )
        )
    }
}