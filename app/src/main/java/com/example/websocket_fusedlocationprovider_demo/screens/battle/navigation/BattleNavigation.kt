package com.example.websocket_fusedlocationprovider_demo.screens.battle.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.websocket_fusedlocationprovider_demo.data.model.RunnerIds
import com.example.websocket_fusedlocationprovider_demo.navigation.NavRoutes
import com.example.websocket_fusedlocationprovider_demo.screens.battle.battle.BattleScreen
import com.example.websocket_fusedlocationprovider_demo.screens.battle.ready.ReadyScreen
import com.google.gson.Gson
import java.net.URLDecoder

private const val ARG_BATTLE_ID = "battleId"
private const val ARG_RUNNER_IDS_JSON = "runnerIdsJson"
private const val DEFAULT_VALUE = ""

fun NavGraphBuilder.readyRoute(
    navigateToBattleWithArgs: (Any?) -> Unit,
    navigateToBattleOnWebSocketError: () -> Unit
) {
    composable(
        route = "${NavRoutes.Ready.route}?battleId={$ARG_BATTLE_ID}&runnerIdsJson={$ARG_RUNNER_IDS_JSON}",
        arguments = listOf(
            navArgument(ARG_BATTLE_ID) {
                type = NavType.StringType
                defaultValue = DEFAULT_VALUE
            },
            navArgument(ARG_RUNNER_IDS_JSON) {
                type = NavType.StringType
                defaultValue = DEFAULT_VALUE
            }
        )
    ) { backStackEntry ->
        val battleId = backStackEntry.arguments?.getString(ARG_BATTLE_ID)
        val runnerIdsJson = backStackEntry.arguments?.getString(ARG_RUNNER_IDS_JSON) ?: DEFAULT_VALUE
        ReadyScreen(
            navigateToBattleWithArgs = navigateToBattleWithArgs,
            navigateToBattleOnWebSocketError = navigateToBattleOnWebSocketError,
            battleId = battleId,
            runnerIdsJson = runnerIdsJson
        )
    }
}

fun NavGraphBuilder.battleRoute() {
    composable(
        route = "${NavRoutes.Battle.route}?runnerIdsJson={$ARG_RUNNER_IDS_JSON}",
        arguments = listOf(
            navArgument(ARG_RUNNER_IDS_JSON) {
                type = NavType.StringType
                defaultValue = DEFAULT_VALUE
            }
        )
    ) { backStackEntry ->
        val runnerIdsJson = backStackEntry.arguments?.getString(ARG_RUNNER_IDS_JSON)
        val decodedRunnerIds = runnerIdsJson?.let {
            URLDecoder.decode(it, "UTF-8")
        }
        val runnerIds = decodedRunnerIds?.let {
            Gson().fromJson(it, RunnerIds::class.java)
        } ?: RunnerIds(emptyList())

        BattleScreen(
            runnerIds = runnerIds
        )
    }
}
