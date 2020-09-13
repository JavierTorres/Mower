package com.javiertorres.mower.domain

import com.javiertorres.mower.domain.location.Coordinate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlateauTest {
    @Test
    fun `Given an upper right coordinate, When setting the plateu Then the plateau is updated`() {
        val upperRightCoordinate = Coordinate(5, 5)
        Plateau.init(Coordinate(5, 5))
        assertEquals(upperRightCoordinate, Plateau.upperRightCoordinate)
    }
}