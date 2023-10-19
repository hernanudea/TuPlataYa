package co.edu.udea.compumovil.gr03.tuplataya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeAddUserView
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeCreditResponseView
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeCreditStateView
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeLoginView
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeSimulatorView


@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Simulator") {

        composable("Login") {
            HomeLoginView(navController = navController)
        }

        composable(
            "AddUser", arguments = listOf()
        ) {
            HomeAddUserView(navController = navController)
        }

        composable(
            "Simulator", arguments = listOf()
        ) {
            HomeSimulatorView(navController = navController)
        }

        composable(
            "creditState", arguments = listOf()
        ) {
            HomeCreditStateView(navController = navController)
        }

        composable(
            "responseState", arguments = listOf()
        ) {
            HomeCreditResponseView(navController = navController)
        }
    }
}