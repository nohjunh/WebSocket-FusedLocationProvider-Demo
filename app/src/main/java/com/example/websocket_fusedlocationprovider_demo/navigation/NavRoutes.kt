package com.example.websocket_fusedlocationprovider_demo.navigation

sealed class NavRoutes(val route: String) {
    object Match: NavRoutes("match")
    object Battle: NavRoutes("battle")
    object Ready: NavRoutes("ready")
}
