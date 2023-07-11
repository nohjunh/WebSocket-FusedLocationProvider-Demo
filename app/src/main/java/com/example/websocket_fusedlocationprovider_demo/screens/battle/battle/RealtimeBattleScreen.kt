package com.example.websocket_fusedlocationprovider_demo.screens.battle.battle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.websocket_fusedlocationprovider_demo.data.state.BattleState
import com.example.websocket_fusedlocationprovider_demo.data.state.RunnerState

@Composable
fun RealtimeBattleScreen(
    battleState: BattleState,
) {
    Spacer(modifier = Modifier.size(30.dp))
    LazyColumn {
        items(battleState.battleInfo) { runnerData ->
            RealtimeBattleScreenItem(runner = runnerData)
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun RealtimeBattleScreenItem(runner: RunnerState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(15.dp)
    ) {
        RunnerStatsColumn(runner)
    }
}

@Composable
fun RunnerStatsColumn(runner: RunnerState) {
    Column {
        Text(text = "Player: ${runner.runnerName}")
        Text(
            text = "Distance: ${runner.distance} KM",
            fontSize = 20.sp
        )
        Text(text = "Rank: ${runner.currentRank}")
        Text(text = "Current Round: ${runner.currentRound}")
    }
}