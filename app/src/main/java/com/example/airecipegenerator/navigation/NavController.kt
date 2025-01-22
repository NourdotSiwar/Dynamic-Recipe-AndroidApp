package com.example.airecipegenerator.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.airecipegenerator.ui.screens.home.HomeScreen
import com.example.airecipegenerator.ui.screens.profile.ProfileScreen
import com.example.airecipegenerator.ui.screens.recipes.RecipesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topLevelRoutesList = topLevelRoutes.map { it.route }

    Scaffold(bottomBar = {
        if (currentDestination?.route in topLevelRoutesList) {
            NavigationBar {
                topLevelRoutes.forEach { topLevelRoute ->
                    NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == topLevelRoute.route } == true,
                        onClick = {
                            navController.navigate(topLevelRoute.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(topLevelRoute.icon, contentDescription = topLevelRoute.name)
                        })
                }
            }
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen(navController)
            }

            composable("recipes") {
                RecipesScreen(navController)
            }

            composable("profile") {
                ProfileScreen(navController)
            }
        }
    }
}