package com.example.websocket_fusedlocationprovider_demo.data

import com.example.websocket_fusedlocationprovider_demo.data.model.BattleEvent
import com.example.websocket_fusedlocationprovider_demo.data.model.GpsData
import kotlinx.coroutines.flow.Flow

interface RealtimeBattleClient {
    fun getBattleStream(battleId: String): Flow<BattleEvent>
    suspend fun sendGPS(battleId: String, gpsData: GpsData)
    suspend fun close()
}
