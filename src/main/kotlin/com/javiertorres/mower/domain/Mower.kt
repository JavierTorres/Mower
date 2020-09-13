package com.javiertorres.mower.domain

import com.javiertorres.mower.domain.command.Command
import com.javiertorres.mower.domain.command.Commander
import com.javiertorres.mower.domain.location.Position

data class Mower(val commands: List<Command>, val initialPosition: Position) {
    fun move() = Commander(commands, initialPosition).process()
}