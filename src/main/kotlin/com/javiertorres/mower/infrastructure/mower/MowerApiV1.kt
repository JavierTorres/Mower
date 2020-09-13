package com.javiertorres.mower.infrastructure.mower

import com.javiertorres.mower.infrastructure.location.PositionDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType

@Api(tags = ["Mower V1"])
interface MowerApiV1 {
    @ApiOperation(
        value = "To set the mower initial position and the instructions",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Mower finial position"),
        ApiResponse(code = 400, message = "Bad request"),
        ApiResponse(code = 500, message = "Server error")])
    fun post(mowerRequest: MowerRequest): PositionDTO
}