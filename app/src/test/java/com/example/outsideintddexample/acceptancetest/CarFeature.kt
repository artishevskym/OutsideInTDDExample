package com.example.outsideintddexample.acceptancetest

import com.example.outsideintddexample.Car
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

import org.junit.Test

class CarFeature {

    private val car = Car(6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() {
        car.turnOn()

        assertTrue(car.engine.isTurnedOn)
        assertEquals(95, car.engine.temperature)
    }
}