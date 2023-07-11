package com.example.websocket_fusedlocationprovider_demo.screens.battle

import com.example.websocket_fusedlocationprovider_demo.data.state.BattleState

data class BattleUiState(
    val isConnecting: Boolean = false,
    val showConnectionError: Boolean = false,
    val battleState: BattleState = BattleState(),
    val timeRemaining: Int = -1,
)
