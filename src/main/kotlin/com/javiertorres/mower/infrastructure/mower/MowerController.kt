package com.javiertorres.mower.infrastructure.mower

import com.javiertorres.mower.application.mower.MoveMowerUseCase
import com.javiertorres.mower.infrastructure.command.CommandMapper
import com.javiertorres.mower.infrastructure.location.PositionDTO
import com.javiertorres.mower.infrastructure.location.PositionMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/mower")
class MowerController(
    private val moveMowerUseCase: MoveMowerUseCase,
    private val positionMapper: PositionMapper,
    private val commandMapper: CommandMapper
) : MowerApiV1 {
    @PostMapping
    override fun post(@RequestBody mowerRequest: MowerRequest): PositionDTO =
        positionMapper.toDTO(
            moveMowerUseCase.exec(
                commandMapper.toCommands(mowerRequest.instructions),
                positionMapper.fromString(mowerRequest.position)))
}