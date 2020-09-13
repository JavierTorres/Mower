package com.javiertorres.mower.infrastructure.location

data class PositionDTO(private val finalPosition: String) {
    fun getFinalPosition() = finalPosition
}