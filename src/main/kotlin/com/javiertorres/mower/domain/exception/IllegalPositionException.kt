package com.javiertorres.mower.domain.exception

open class IllegalPositionException(message: String, throwable: Throwable? = null) :
    RuntimeException(message, throwable)