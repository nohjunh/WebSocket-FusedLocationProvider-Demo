package com.example.websocket_fusedlocationprovider_demo.screens.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.websocket_fusedlocationprovider_demo.R
import com.example.websocket_fusedlocationprovider_demo.data.model.RunnerIds
import com.google.gson.Gson

@Composable
fun MatchScreen(
    navigateToReadyWithArgs: (String, String) -> Unit
) {
    /* Mock Data */
    val gson = Gson()
    val runnerIds = RunnerIds(listOf("123", "456"))
    val runnerIdsJson = gson.toJson(runnerIds)

    val battleId = "Battle ID"
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navigateToReadyWithArgs(battleId, runnerIdsJson)
            }
        ) {
            Text(text = stringResource(id = R.string.connect_websocket_title))
        }
    }
}
