package com.javiertorres.mower.infrastructure.mower

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "MowerRequest", description = "Contains the request params")
data class MowerRequest(
    @ApiModelProperty(value = "Position", required = true) val position: String,
    @ApiModelProperty(value = "Instructions", required = true) val instructions: String) {

    init {
        validate()
    }

    private fun validate() {
        if (!Regex(POSITION_REGEX).matches(position)) {
            throw IllegalArgumentException("The position doesn't match the format: [number] [number] [NnEeSsWw]")
        }

        if (!Regex(INSTRUCTION_REGEX).matches(instructions)) {
            throw IllegalArgumentException("The instructions can only contain L, R and M")
        }
    }

    companion object {
        const val POSITION_REGEX = "^\\d+\\s\\d+\\s[NnSsEeWw]$"
        const val INSTRUCTION_REGEX = "^[LlRrMm]*$"
    }
}