package com.javiertorres.mower.domain

import com.javiertorres.mower.domain.location.Coordinate

object Plateau {
    val bottomLeftCoordinate: Coordinate = Coordinate(0, 0)
    var upperRightCoordinate: Coordinate = bottomLeftCoordinate

    fun init(newUpperRightCoordinate: Coordinate) {
        upperRightCoordinate = newUpperRightCoordinate
    }
}