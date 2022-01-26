package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
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
    fun riseTheTemperatureGraduallyWhenItTurnsOn() = runBlockingTest {
        val flow = engine.turnOn()
        val actual = flow.toList()

        assertEquals(listOf(25, 50, 95), actual)
    }
}