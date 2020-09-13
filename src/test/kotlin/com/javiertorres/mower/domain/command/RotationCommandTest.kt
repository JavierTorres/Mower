package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import com.javiertorres.mower.domain.location.Rotation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RotationCommandTest {
    private val coordinate = Coordinate(2,2)
    private val rotationLeftCommand = RotationCommand(Rotation.LEFT)
    private val rotationRightCommand = RotationCommand(Rotation.RIGHT)

    @Test
    fun `Given an initial North direction when rotating right then it should be East`() {
        assertEquals(Position(coordinate, Direction.E), rotationRightCommand.execute(Position(coordinate, Direction.N)))
    }

    @Test
    fun `Given an initial East direction when rotating right then it should be Sud`() {
        assertEquals(Position(coordinate, Direction.S), rotationRightCommand.execute(Position(coordinate, Direction.E)))
    }

    @Test
    fun `Given an initial Sud direction when rotating right then it should be West`() {
        assertEquals(Position(coordinate, Direction.W), rotationRightCommand.execute(Position(coordinate, Direction.S)))
    }

    @Test
    fun `Given an initial West direction when rotating right then it should be North`() {
        assertEquals(Position(coordinate, Direction.N), rotationRightCommand.execute(Position(coordinate, Direction.W)))
    }

    @Test
    fun `Given an initial North direction when rotating left then it should be West`() {
        assertEquals(Position(coordinate, Direction.W), rotationLeftCommand.execute(Position(coordinate, Direction.N)))
    }

    @Test
    fun `Given an initial West direction when rotating left then it should be Sud`() {
        assertEquals(Position(coordinate, Direction.S), rotationLeftCommand.execute(Position(coordinate, Direction.W)))
    }

    @Test
    fun `Given an initial Sud direction when rotating left then it should be East`() {
        assertEquals(Position(coordinate, Direction.E), rotationLeftCommand.execute(Position(coordinate, Direction.S)))
    }

    @Test
    fun `Given an initial East direction when rotating left then it should be North`() {
        assertEquals(Position(coordinate, Direction.N), rotationLeftCommand.execute(Position(coordinate, Direction.E)))
    }
}