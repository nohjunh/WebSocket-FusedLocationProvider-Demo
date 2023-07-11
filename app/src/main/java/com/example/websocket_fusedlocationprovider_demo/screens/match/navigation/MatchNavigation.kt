package com.example.websocket_fusedlocationprovider_demo.screens.match.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.websocket_fusedlocationprovider_demo.navigation.NavRoutes
import com.example.websocket_fusedlocationprovider_demo.screens.match.MatchScreen

fun NavGraphBuilder.matchRoute(
    navigateToReadyWithArgs: (String, Any?) -> Unit,
) {
    composable(route = NavRoutes.Match.route) {
        MatchScreen(
            navigateToReadyWithArgs = navigateToReadyWithArgs,
        )
    }
}
