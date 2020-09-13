package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import com.javiertorres.mower.domain.location.Rotation

data class RotationCommand(private val rotation: Rotation): Command {
    override fun execute(newPosition: Position) =
        when (rotation) {
            Rotation.LEFT ->
                if (newPosition.direction == Direction.N) {
                    Position(newPosition.coordinate, Direction.W)
                } else {
                    Position(newPosition.coordinate, Direction.values()[newPosition.direction.ordinal - 1])
                }
            Rotation.RIGHT ->
                if (newPosition.direction == Direction.W) {
                    Position(newPosition.coordinate, Direction.N)
                } else {
                    Position(newPosition.coordinate, Direction.values()[newPosition.direction.ordinal + 1])
                }
        }
}