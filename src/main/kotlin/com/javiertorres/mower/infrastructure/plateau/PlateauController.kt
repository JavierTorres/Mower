package com.javiertorres.mower.infrastructure.plateau

import com.javiertorres.mower.application.plateau.SetPlateauUseCase
import com.javiertorres.mower.infrastructure.location.CoordinateMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/plateau")
class PlateauController(
    private val setPlateauUseCase: SetPlateauUseCase,
    private val coordinateMapper: CoordinateMapper
) : PlateauApiV1 {
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun put(@RequestBody plateauRequest: PlateauRequest) =
        setPlateauUseCase.exec(coordinateMapper.toCoordinate(plateauRequest.upperRightCoordinate))
}