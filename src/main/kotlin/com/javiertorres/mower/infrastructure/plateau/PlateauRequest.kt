package com.javiertorres.mower.infrastructure.plateau

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "PlateauRequest", description = "Contains the request params")
data class PlateauRequest(
    @ApiModelProperty(value = "Coordinate", required = true)
    @JsonProperty("upperRightCoordinate") val upperRightCoordinate: String) {

    init {
        validate()
    }

    private fun validate() {
        if (!Regex(COORDINATE_REGEX).matches(upperRightCoordinate)) {
            throw IllegalArgumentException("The coordinate doesn't match the format: [number] [number]")
        }
    }

    companion object {
        const val COORDINATE_REGEX = "^\\d+\\s\\d+$"
    }
}