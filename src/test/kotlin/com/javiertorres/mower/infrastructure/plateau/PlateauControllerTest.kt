package com.javiertorres.mower.infrastructure.plateau

import com.javiertorres.mower.application.plateau.SetPlateauUseCase
import com.javiertorres.mower.domain.Plateau
import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.infrastructure.location.CoordinateMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class PlateauControllerTest {
    @Test
    fun `Given an empty request When processing the request Then it throws an exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            PlateauController(
                SetPlateauUseCase(Plateau),
                CoordinateMapper())
                .put(PlateauRequest(""))
        }
    }

    @Test
    fun `Given an invalid request When processing the request Then it throws an exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            PlateauController(
                SetPlateauUseCase(Plateau),
                CoordinateMapper())
                .put(PlateauRequest("a 5"))
        }
    }

    @Test
    fun `Given a plateau request When processing the request Then the plateau gets updated`() {
        PlateauController(SetPlateauUseCase(Plateau), CoordinateMapper()).put(PlateauRequest("5 5"))
        assertEquals(Coordinate(5, 5), Plateau.upperRightCoordinate)
    }
}