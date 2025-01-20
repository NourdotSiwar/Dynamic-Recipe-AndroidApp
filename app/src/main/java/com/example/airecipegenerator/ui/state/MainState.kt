package com.example.airecipegenerator.ui.state

sealed class MainState{
    object Idle: MainState()
    object Loading: MainState()
    data class Success(val data: Any): MainState()
    data class Error(val error: String?): MainState()
}