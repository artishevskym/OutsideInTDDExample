package com.example.outsideintddexample.acceptancetest

import com.example.outsideintddexample.Car
import junit.framework.Assert.assertEquals
import org.junit.Test

class CarFeature {

    private val car = Car(6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }
}