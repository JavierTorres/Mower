package com.javiertorres.mower.infrastructure.plateau

import com.javiertorres.mower.application.plateau.SetPlateauUseCase
import com.javiertorres.mower.domain.Plateau
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SetPlateauUseCaseConfiguration {
    @Bean
    fun getSetPlateauUseCase(plateau : Plateau) = SetPlateauUseCase(plateau)
}