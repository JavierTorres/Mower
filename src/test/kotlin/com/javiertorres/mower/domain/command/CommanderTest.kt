package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.exception.IllegalPositionException
import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class CommanderTest {
    private val position = Position(Coordinate(3, 3), Direction.W)

    @Test
    fun `Given an empty list of commands When processing return the initial position`() {
        assertEquals(position, Commander(emptyList(), position).process())
    }

    @Test
    fun `Given a command throwing an exception When processing Then it returns the last ok position`() {
        val commandException: Command = mock()
        given(commandException.execute(any())).willThrow(IllegalPositionException("test"))
        assertEquals(position, Commander(listOf(commandException), position).process())
    }

    @Test
    fun `Given a command returning a new position When processing Then it returns the last ok position`() {
        val command: Command = mock()
        val finalPosition = Position(Coordinate(2, 3), Direction.W)
        given(command.execute(any())).willReturn(finalPosition)
        assertEquals(finalPosition, Commander(listOf(command), position).process())
    }
}