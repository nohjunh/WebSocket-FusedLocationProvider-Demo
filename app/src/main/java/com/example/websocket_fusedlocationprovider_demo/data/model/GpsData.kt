package com.example.websocket_fusedlocationprovider_demo.data.model

import java.time.LocalDateTime

data class GpsData(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val gpsTime: LocalDateTime = LocalDateTime.now()
)
