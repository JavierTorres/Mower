package com.javiertorres.mower.infrastructure.mower

import com.javiertorres.mower.application.mower.MoveMowerUseCase
import com.javiertorres.mower.application.plateau.SetPlateauUseCase
import com.javiertorres.mower.domain.Plateau
import com.javiertorres.mower.infrastructure.command.CommandMapper
import com.javiertorres.mower.infrastructure.location.CoordinateMapper
import com.javiertorres.mower.infrastructure.location.PositionMapper
import com.javiertorres.mower.infrastructure.plateau.PlateauController
import com.javiertorres.mower.infrastructure.plateau.PlateauRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MowerControllerTest {
    @Test
    fun `Given an empty request When processing the request Then it throws an exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            MowerController(MoveMowerUseCase(), PositionMapper(), CommandMapper())
                .post(MowerRequest("", ""))
                .getFinalPosition()
        }
    }

    @Test
    fun `Given an invalid request When processing the request Then it throws an exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            MowerController(MoveMowerUseCase(), PositionMapper(), CommandMapper())
                .post(MowerRequest("ab", "zz"))
                .getFinalPosition()
        }
    }

    @Test
    fun `Given a request containing an instruction to move outside When processing Then returns last valid position`() {
        // Sets the initial upper right coordinate for the plateau
        PlateauController(SetPlateauUseCase(Plateau), CoordinateMapper()).put(PlateauRequest("5 5"))

        assertEquals("1 5 N",
            MowerController(MoveMowerUseCase(), PositionMapper(), CommandMapper())
                .post(MowerRequest("1 2 N", "LMLMLMLMMMMM"))
                .getFinalPosition())
    }

    @Test
    fun `Given a valid request When processing Then mower gets moved`() {
        // Sets the initial upper right coordinate for the plateau
        PlateauController(SetPlateauUseCase(Plateau), CoordinateMapper()).put(PlateauRequest("5 5"))

        assertEquals("1 3 N",
            MowerController(MoveMowerUseCase(), PositionMapper(), CommandMapper())
                .post(MowerRequest("1 2 N", "LMLMLMLMM"))
                .getFinalPosition())
    }
}