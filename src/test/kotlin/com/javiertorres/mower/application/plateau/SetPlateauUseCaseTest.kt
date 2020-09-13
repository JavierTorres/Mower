package com.javiertorres.mower.application.plateau

import com.javiertorres.mower.domain.Plateau
import com.javiertorres.mower.domain.location.Coordinate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SetPlateauUseCaseTest {
    @Test
    fun `Given an upper right coordinate, When executing the use case Then the plateau is updated`() {
        val upperRightCoordinate = Coordinate(5, 5)
        SetPlateauUseCase(Plateau).exec(upperRightCoordinate)
        assertEquals(upperRightCoordinate, Plateau.upperRightCoordinate)
    }
}