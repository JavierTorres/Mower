package com.javiertorres.mower.infrastructure.mower

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MowerRequestTest {
    @Test
    fun `Given an empty position When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("", "LRM")
        }
    }

    @Test
    fun `Given position with just x When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4", "LRM")
        }
    }

    @Test
    fun `Given position with just x and y When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4 3", "LRM")
        }
    }

    @Test
    fun `Given position containing not expected characters at x coordinate When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4d 3 N", "LRM")
        }
    }

    @Test
    fun `Given position containing not expected characters at y coordinate When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4 3a N", "LRM")
        }
    }

    @Test
    fun `Given position not containing blank spaces When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("43N", "LRM")
        }
    }

    @Test
    fun `Given position containing not expected direction When validation Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4 3 Z", "LRM")
        }
    }

    @Test
    fun `Given a valid north uppercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 N", "LRM")
        }
    }

    @Test
    fun `Given a valid north lowercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 n", "LRM")
        }
    }

    @Test
    fun `Given a valid east uppercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 E", "LRM")
        }
    }

    @Test
    fun `Given a valid easet lowercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 e", "LRM")
        }
    }

    @Test
    fun `Given a valid sud uppercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 S", "LRM")
        }
    }

    @Test
    fun `Given a valid sud lowercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 s", "LRM")
        }
    }

    @Test
    fun `Given a valid west uppercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 W", "LRM")
        }
    }

    @Test
    fun `Given a valid west lowercase position and instructions When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 w", "LRM")
        }
    }

    @Test
    fun `Given instruction not containing a expected character When validation Then does not throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            MowerRequest("4 3 N", "LaR")
        }
    }

    @Test
    fun `Given a valid instructions character When validation Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            MowerRequest("4 4 w", "LRMlrmLLrrMM")
        }
    }
}