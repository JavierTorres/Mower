package com.javiertorres.mower.application.plateau

import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.Plateau

class SetPlateauUseCase(private val plateau: Plateau) {
    fun exec(coordinate: Coordinate) = plateau.init(coordinate)
}