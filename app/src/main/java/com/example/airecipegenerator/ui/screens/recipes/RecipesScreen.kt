package com.example.airecipegenerator.ui.screens.recipes

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.airecipegenerator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(topBar = {
        RecipesTopAppBar(
            navController = navController, context = context
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("No Recipes Yet!")
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun RecipesTopAppBar(
    navController: NavController,
    context: Context,
) {
    TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary
    ), title = {
        Text(
            stringResource(id = R.string.app_name)
        )
    }, actions = {
        IconButton(
            onClick = {
                navController.navigate("profile")
            },
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = null
            )
        }
    })
}