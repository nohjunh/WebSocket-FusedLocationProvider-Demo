package com.example.websocket_fusedlocationprovider_demo.data.model

import java.time.LocalDateTime

sealed class BattleEvent {
    data class BattleReadyResult(
        val startTime: LocalDateTime
    ): BattleEvent()

    data class RunnerResult(
        val isFinished: Boolean = false,
        val runnerId: String = "",
        val distance: Double = 0.0
    ): BattleEvent()

    data class BattleDefaultResult(
        val message: String = ""
    ): BattleEvent()
}
