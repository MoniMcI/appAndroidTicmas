package com.curso.android.app.miappticmas

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.miappticmas.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun mainViewModel_CheckInitialComparison() = runTest {
        //pruebo comparenumbers del mainviewmodel

        // valores iniciales
        val num1 = 5
        val num2 = 3

        // dispara la comparacion
        viewModel.compareNumbers(num1, num2)

        // resultado
        val result = viewModel.compare.value
        assertEquals(0, result?.number)
    }

    @Test
    fun mainViewModel_CheckMessage() = runTest {
        val num1 = 5
        val num2 = 3

        viewModel.compareNumbers(num1, num2)

        val resultMessage = viewModel.message.value
        assertEquals("Los números son diferentes", resultMessage)
    }

}