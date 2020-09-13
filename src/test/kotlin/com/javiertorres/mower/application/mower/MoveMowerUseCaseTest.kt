package com.javiertorres.mower.application.mower

import com.javiertorres.mower.domain.command.Command
import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MoveMowerUseCaseTest {
    @Test
    fun `Given a command returning a new position When executing the use case Then it returns the last ok position`() {
        val command: Command = mock()
        val finalPosition = Position(Coordinate(2, 3), Direction.W)
        given(command.execute(any())).willReturn(finalPosition)
        assertEquals(
            finalPosition,
            MoveMowerUseCase().exec(listOf(command), Position(Coordinate(3, 3), Direction.W)))
    }
}