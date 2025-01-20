package com.example.airecipegenerator.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelRoute(val name: String, val route: String, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute("Home","home", Icons.Default.Home),
    TopLevelRoute("Saved Recipes","recipes",Icons.Default.List),
    TopLevelRoute("Profile","profile",Icons.Default.AccountCircle)
)
