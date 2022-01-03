package com.example.outsideintddexample.acceptancetest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule

import org.junit.Test

class CarFeature {

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    private val engine = Engine()
    private val car = Car(engine,6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlockingTest  {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runBlockingTest  {
        car.turnOn()

        // advance time
        coroutinesTestRule.advanceTimeBy(6001)

        assertTrue(car.engine.isTurnedOn)
        assertEquals(95, car.engine.temperature)
    }
}