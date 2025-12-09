//package com.example.nadanao.front
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHost
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.nadanao.front.HomePage
//import com.example.nadanao.front.pages.AguaBoaPage
//import com.example.nadanao.front.pages.PraiaLimpaPage
//import com.example.nadanao.front.pages.PorDentroPraiaPage
//import com.example.nadanao.front.pages.ChecklistPage
//
//@Composable
//fun MainNavHost(navController: NavHostController) {
//
//    NavHost(
//        navController = navController,
//        startDestination = Route.Home
//    ) {
//        composable<Route.Home> {
//            HomePage(navController)
//        }
//
//        composable<Route.AguaBoa> {
//            AguaBoaPage()
//        }
//
//        composable<Route.PraiaLimpa> {
//            PraiaLimpaPage()
//        }
//
//        composable<Route.PorDentroDaPraia> {
//            PorDentroPraiaPage()
//        }
//
//        composable<Route.Checklist> {
//            ChecklistPage()
//        }
//    }
//}
