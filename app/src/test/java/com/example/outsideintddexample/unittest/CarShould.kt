package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(5.0, engine)

    @Test
    fun loosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}