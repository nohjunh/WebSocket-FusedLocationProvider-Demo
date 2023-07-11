package com.example.websocket_fusedlocationprovider_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.websocket_fusedlocationprovider_demo.screens.battle.navigation.battleRoute
import com.example.websocket_fusedlocationprovider_demo.screens.battle.navigation.readyRoute
import com.example.websocket_fusedlocationprovider_demo.screens.match.navigation.matchRoute

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        matchRoute(
            navigateToReadyWithArgs = { battleId, runnerIdsJson ->
                navController.navigate("${NavRoutes.Ready.route}?battleId=$battleId&runnerIdsJson=$runnerIdsJson")
            },
        )
        readyRoute(
            navigateToBattleWithArgs = { runnerIdsJson ->
                navController.navigate("${NavRoutes.Battle.route}?runnerIdsJson=$runnerIdsJson") {
                    popUpTo(NavRoutes.Ready.route)
                }
            },
            navigateToBattleOnWebSocketError = {
                /*
                navController.navigate(NavRoutes.Match.route) {
                    popUpTo(NavRoutes.Battle.route)
                }
                */
            }
        )
        battleRoute()
    }
}
