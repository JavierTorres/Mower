package com.javiertorres.mower.infrastructure.location

import com.javiertorres.mower.domain.location.Coordinate
import org.springframework.stereotype.Component

@Component
class CoordinateMapper {
    fun toCoordinate(coordinate: String): Coordinate {
        val split = coordinate.split(" ")
        return Coordinate(split[0].toShort(), split[1].toShort())
    }
}