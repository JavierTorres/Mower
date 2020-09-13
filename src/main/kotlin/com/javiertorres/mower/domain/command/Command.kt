package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.location.Position

interface Command {
    fun execute(position: Position): Position
}