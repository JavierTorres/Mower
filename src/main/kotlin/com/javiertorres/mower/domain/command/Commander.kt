package com.javiertorres.mower.domain.command

import com.javiertorres.mower.domain.exception.IllegalPositionException
import com.javiertorres.mower.domain.location.Position
import org.slf4j.LoggerFactory

data class Commander(private val commands: List<Command>, private val position: Position) {
    fun process(): Position {
        var finalPosition = position
        commands.forEach {
           finalPosition =
                try { it.execute(finalPosition) }
                catch (e: IllegalPositionException) {
                    LOGGER.info(
                        "This position $position is outside of the tableau, when processing a command", e)
                    return finalPosition
                }
        }
        return finalPosition
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Commander::class.java)
    }
}