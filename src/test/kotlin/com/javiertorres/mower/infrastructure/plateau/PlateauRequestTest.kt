package com.javiertorres.mower.infrastructure.plateau

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PlateauRequestTest {
    @Test
    fun `Given an empty upperRightCoordinate When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("")
        }
    }

    @Test
    fun `Given an upperRightCoordinate no containing numbers When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("a")
        }
    }

    @Test
    fun `Given an upperRightCoordinate containing number and letter When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("4a")
        }
    }

    @Test
    fun `Given an upperRightCoordinate no containing a blank space When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("44")
        }
    }

    @Test
    fun `Given an upperRightCoordinate no containing the y When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("4 ")
        }
    }

    @Test
    fun `Given an upperRightCoordinate containing negative x When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("-4 3")
        }
    }

    @Test
    fun `Given an upperRightCoordinate containing negative y When validating Then throw an exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            PlateauRequest("4 -3")
        }
    }

    @Test
    fun `Given a valid upperRightCoordinate When validating Then does not throw an exception`() {
        Assertions.assertDoesNotThrow {
            PlateauRequest("4 4")
        }
    }
}