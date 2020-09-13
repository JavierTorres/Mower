package com.javiertorres.mower.infrastructure.mower

import com.javiertorres.mower.application.mower.MoveMowerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MoveMowerUseCaseConfiguration() {
    @Bean
    fun getMoveMowerUseCase() = MoveMowerUseCase()
}