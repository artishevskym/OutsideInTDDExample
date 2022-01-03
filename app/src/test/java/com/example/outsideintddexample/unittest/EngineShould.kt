package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import org.junit.Test

class EngineShould {

    val engine = Engine()

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }
}