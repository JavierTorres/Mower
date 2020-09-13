package com.javiertorres.mower.infrastructure.command

import com.javiertorres.mower.domain.command.Command
import com.javiertorres.mower.domain.command.MoveForwardCommand
import com.javiertorres.mower.domain.location.Rotation
import com.javiertorres.mower.domain.command.RotationCommand
import org.springframework.stereotype.Component

@Component
class CommandMapper {
    fun toCommands(instructions: String): List<Command> = instructions.toCharArray().map { parseToCommand(it) }

    private fun parseToCommand(command: Char): Command =
        when (command) {
            "L".single() -> RotationCommand(Rotation.LEFT)
            "l".single() -> RotationCommand(Rotation.LEFT)
            "R".single() -> RotationCommand(Rotation.RIGHT)
            "r".single() -> RotationCommand(Rotation.RIGHT)
            "M".single() -> MoveForwardCommand()
            "m".single() -> MoveForwardCommand()
            else -> throw IllegalArgumentException("Invalid command $command")
        }
}