package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    private val engine = Engine()

    @Test
    fun turnOn() = runBlockingTest {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnsOn() = runBlockingTest  {
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }
}