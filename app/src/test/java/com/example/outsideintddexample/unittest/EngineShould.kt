package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EngineShould {

    val engine = Engine(false)

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }
}