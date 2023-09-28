package com.example.project_one.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_one.ui.theme.pages.products.ViewProductsScreen
import com.example.project_one.ui.theme.pages.products.ViewUploadsScreen
import com.example.project_one.ui.theme.pages.about.AboutScreen
import com.example.project_one.ui.theme.pages.home.HomeScreen
import com.example.project_one.ui.theme.pages.login.LoginScreen
import com.example.project_one.ui.theme.pages.products.AddProductsScreen
import com.example.project_one.ui.theme.pages.products.ServiceScreen
import com.example.project_one.ui.theme.pages.products.ViewUploadsScreen
import com.example.project_one.ui.theme.pages.signup.SignupScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination:String = ROUTE_HOME) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCTS) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCTS) {
            ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCTS + "/{id}") { passedData ->
            ServiceScreen(navController, passedData.arguments?.getString("id")!!)
        }

    }

}

