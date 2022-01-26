package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CarShould {

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    private val engine: Engine = mock()
    private val car: Car

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }

        car = Car(engine, 5.0)
    }

    @Test
    fun loosingFuelWhenItTurnsOn() = runBlockingTest  {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}