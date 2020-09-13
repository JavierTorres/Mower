package com.javiertorres.mower.infrastructure.plateau

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType

@Api(tags = ["Plateau V1"])
interface PlateauApiV1 {
    @ApiOperation(
            value = "To set the plateu upper-right coordinate",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = [
        ApiResponse(code = 204, message = "Plateau upper-right coordinate has been set successfully"),
        ApiResponse(code = 400, message = "Bad request"),
        ApiResponse(code = 500, message = "Server error")])
    fun put(plateauRequest: PlateauRequest)
}
