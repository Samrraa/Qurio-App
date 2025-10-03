package com.samrraa.qurioapp.view.home.model

import kotlinx.datetime.*

data class History(
    val date: String,
    val coin: Int,
    val star: String,
    val subject: String,
    val time: LocalDateTime
)