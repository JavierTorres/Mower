package com.javiertorres.mower.infrastructure.plateau

import com.javiertorres.mower.domain.Plateau
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PlateauConfiguration {
    @Bean
    fun getPlateau() = Plateau
}