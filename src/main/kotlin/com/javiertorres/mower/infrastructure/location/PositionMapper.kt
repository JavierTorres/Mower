package com.javiertorres.mower.infrastructure.location

import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position
import org.springframework.stereotype.Component

@Component
class PositionMapper {
    fun toDTO(position: Position): PositionDTO =
        PositionDTO("${position.coordinate.x} ${position.coordinate.y} ${position.direction.name}")

    fun fromString(position: String): Position {
        val split = position.split(" ")
        return Position(
            Coordinate(split[X_POSITION].toShort(), split[Y_POSITION].toShort()),
            Direction.valueOf(split[DIRECTION_POSITION].toUpperCase()))
    }

    companion object {
        const val X_POSITION = 0
        const val Y_POSITION = 1
        const val DIRECTION_POSITION = 2
    }
}