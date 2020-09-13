package com.javiertorres.mower.infrastructure.command

import com.javiertorres.mower.domain.command.MoveForwardCommand
import com.javiertorres.mower.domain.command.RotationCommand
import com.javiertorres.mower.domain.location.Rotation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CommandMapperTest {
    private val commandMapper = CommandMapper()
    private val rotationLeftCommand = RotationCommand(Rotation.LEFT)
    private val rotationRightCommand = RotationCommand(Rotation.RIGHT)

    @Test
    fun `Given an invalid command When parsing Then throws an exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            commandMapper.toCommands("Z")
        }
    }

    @Test
    fun `Given a L character When parsing Then returns a Rotation Left Command`() {
        assertEquals(rotationLeftCommand, commandMapper.toCommands("L").first())
    }

    @Test
    fun `Given a l character When parsing Then returns a Rotation Left Command`() {
        assertEquals(rotationLeftCommand, commandMapper.toCommands("l").first())
    }

    @Test
    fun `Given a R character When parsing Then returns a Rotation Right Command`() {
        assertEquals(rotationRightCommand, commandMapper.toCommands("R").first())
    }

    @Test
    fun `Given a r character When parsing Then returns a Rotation Left Command`() {
        assertEquals(rotationRightCommand, commandMapper.toCommands("r").first())
    }

    @Test
    fun `Given a M character When parsing Then returns a Move Forward Command`() {
        assertEquals(MoveForwardCommand::class.java, commandMapper.toCommands("M").first().javaClass)
    }

    @Test
    fun `Given a m character When parsing Then returns a Move Forward Command`() {
        assertEquals(MoveForwardCommand::class.java, commandMapper.toCommands("m").first().javaClass)
    }
}