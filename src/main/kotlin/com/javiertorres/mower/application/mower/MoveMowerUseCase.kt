package com.javiertorres.mower.application.mower

import com.javiertorres.mower.domain.Mower
import com.javiertorres.mower.domain.command.Command
import com.javiertorres.mower.domain.location.Position

class MoveMowerUseCase() {
    fun exec(commands: List<Command>, initialPosition: Position): Position = Mower(commands, initialPosition).move()
}