package com.example.blu_compose.ui.navigation

sealed class Route(val route: String) {
    object Home : Route("home")
    object Profile : Route("profile")
    object DetailCampus : Route("home/{campusId}") {
        fun createRoute(campusId: Long) = "home/$campusId"
    }
}