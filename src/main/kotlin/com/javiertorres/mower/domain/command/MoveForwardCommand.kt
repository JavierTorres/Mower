package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.Plateau
import com.javiertorres.mower.domain.exception.IllegalPositionException
import com.javiertorres.mower.domain.location.Coordinate
import com.javiertorres.mower.domain.location.Direction
import com.javiertorres.mower.domain.location.Position

class MoveForwardCommand : Command {
    override fun execute(newPosition: Position): Position {
        val finalPosition = when (newPosition.direction) {
            Direction.N -> Position(Coordinate(newPosition.coordinate.x, newPosition.coordinate.y.inc()), newPosition.direction)
            Direction.E -> Position(Coordinate(newPosition.coordinate.x.inc(), newPosition.coordinate.y), newPosition.direction)
            Direction.S -> Position(Coordinate(newPosition.coordinate.x, newPosition.coordinate.y.dec()), newPosition.direction)
            Direction.W -> Position(Coordinate(newPosition.coordinate.x.dec(), newPosition.coordinate.y), newPosition.direction)
        }
        validatePlateauDimensions(finalPosition)
        return finalPosition
    }

    private fun validatePlateauDimensions(finalPosition: Position) {
        if (finalPosition.coordinate.x > Plateau.upperRightCoordinate.x ||
            finalPosition.coordinate.y > Plateau.upperRightCoordinate.y ||
            finalPosition.coordinate.x < Plateau.bottomLeftCoordinate.x ||
            finalPosition.coordinate.y < Plateau.bottomLeftCoordinate.y) {
            throw IllegalPositionException(
                "Invalid position $finalPosition for the mower, it's not at the plateau area")
        }
    }




}