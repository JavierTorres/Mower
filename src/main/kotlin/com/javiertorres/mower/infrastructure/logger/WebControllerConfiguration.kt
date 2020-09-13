package com.javiertorres.mower.infrastructure.logger

import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@Import(
    JacksonAutoConfiguration::class,
    ErrorHandler::class)
@EnableSwagger2
class WebControllerConfiguration
