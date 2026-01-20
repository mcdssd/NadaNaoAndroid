package com.example.nadanao

import HomePage
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nadanao.front.AguaBoa
import com.example.nadanao.front.Checklist
import com.example.nadanao.front.MapPage
import com.example.nadanao.front.PorDentroPraia
import com.example.nadanao.front.PraiaLimpa
import com.example.nadanao.viewmodel.MapViewModel

@Composable
fun AppNavigation(viewModel: MapViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomePage(navController)
        }

        composable("PraiaLimpa") {
            PraiaLimpa()
        }

        composable("Checklist") {
            Checklist()
        }

        composable("AguaBoa") {
            AguaBoa()
        }

        composable("PorDentroPraia") {
            PorDentroPraia()
        }

        composable("mapa") {
            MapPage(viewModel)
        }
    }
}
