package com.example.websocket_fusedlocationprovider_demo.screens.battle.battle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.websocket_fusedlocationprovider_demo.data.model.RunnerIds
import com.example.websocket_fusedlocationprovider_demo.screens.battle.BattleViewModel

@Composable
fun BattleScreen(
    runnerIds: RunnerIds,
    viewModel: BattleViewModel = hiltViewModel()
) {
    val battleUiState by viewModel.battleUiState.collectAsState()

    // 러너 데이터를 기반으로 BattleState를 초기화하고 시작
    LaunchedEffect(runnerIds) {
        viewModel.initBattleState(runnerIds)
    }

    // 위치 업데이트 시작 및 정지 로직
    DisposableEffect(Unit) {
        viewModel.startLocationUpdates()
        onDispose {
            viewModel.stopLocationUpdates()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        if (battleUiState.isConnecting) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            RealtimeBattleScreen(
                battleState = battleUiState.battleState,
            )
        }
    }
}
