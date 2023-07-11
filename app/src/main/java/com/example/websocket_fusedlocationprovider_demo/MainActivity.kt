package com.example.websocket_fusedlocationprovider_demo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.websocket_fusedlocationprovider_demo.navigation.NavRoutes
import com.example.websocket_fusedlocationprovider_demo.navigation.SetupNavGraph
import com.example.websocket_fusedlocationprovider_demo.ui.theme.WebSocketFusedLocationProviderDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // 사용자로부터 위치 접근 권한을 요청하고 그 결과를 받아 처리하기 위한 코드
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) { // 사용자가 권한을 승인하면
                Timber.tag("MainActivity").d("위치 접근 권한 승인")
            }
        }

    // 사용자로부터 위치 접근 권한이 부여되어 있는지 확인하고, 부여되어 있지 않다면 권한을 요청
    private fun askPermissions() {
        val hasLocationPermission = PackageManager.PERMISSION_GRANTED ==
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

        if (!hasLocationPermission) {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 권한 확인 및 요청
        askPermissions()

        setContent {
            WebSocketFusedLocationProviderDemoTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph(
                        navController = navController,
                        startDestination = NavRoutes.Match.route
                    )
                }
            }
        }
    }
}
