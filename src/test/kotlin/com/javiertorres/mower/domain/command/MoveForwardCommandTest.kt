package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.Plateau
import com.javiertorres.mower.domain.exception.IllegalPositionException
import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MoveForwardCommandTest {
    private val coordinate = Coordinate(1,1)
    private val moveForwardCommand = MoveForwardCommand()

    init {
        Plateau.init(Coordinate(5,5))
    }

    @Test
    fun `Given an initial North direction when moving forward then the y coordinate should increase one unit`() {
        assertEquals(Position(Coordinate(1,2), Direction.N),
            moveForwardCommand.execute(Position(coordinate, Direction.N)))
    }

    @Test
    fun `Given an initial East direction when moving forward then the x coordinate should increase one unit`() {
        assertEquals(Position(Coordinate(2,1), Direction.E),
            moveForwardCommand.execute(Position(coordinate, Direction.E)))
    }

    @Test
    fun `Given an initial Sud direction when moving forward then the y coordinate should decrease one unit`() {
        assertEquals(Position(Coordinate(1,0), Direction.S),
            moveForwardCommand.execute(Position(coordinate, Direction.S)))
    }

    @Test
    fun `Given an initial West direction when moving forward then the x coordinate should decrease one unit`() {
        assertEquals(Position(Coordinate(0,1), Direction.W),
            moveForwardCommand.execute(Position(coordinate, Direction.W)))
    }

    @Test
    fun `Given an initial North direction when moving forward outside of the plateau then throw an exception`() {
        Plateau.init(coordinate)
        Assertions.assertThrows(IllegalPositionException::class.java) {
            moveForwardCommand.execute(Position(coordinate, Direction.N))
        }
    }

    @Test
    fun `Given an initial East direction when moving forward outside of the plateau then throw an exception`() {
        Plateau.init(coordinate)
        Assertions.assertThrows(IllegalPositionException::class.java) {
            moveForwardCommand.execute(Position(coordinate, Direction.E))
        }
    }

    @Test
    fun `Given an initial Sud direction when moving forward outside of the plateau then throw an exception`() {
        Plateau.init(coordinate)
        Assertions.assertThrows(IllegalPositionException::class.java) {
            moveForwardCommand.execute(Position(Coordinate(0, 0), Direction.S))
        }
    }

    @Test
    fun `Given an initial West direction when moving forward outside of the plateau then throw an exception`() {
        Plateau.init(coordinate)
        Assertions.assertThrows(IllegalPositionException::class.java) {
            moveForwardCommand.execute(Position(Coordinate(0, 0), Direction.W))
        }
    }

}