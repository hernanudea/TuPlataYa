package co.edu.udea.compumovil.gr03.tuplataya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr03.tuplataya.views.HomeLoginView


@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            HomeLoginView(navController)
        }
        composable("Contact", arguments = listOf()
//        composable("Contact/{appStateJson}", arguments = listOf(
//            navArgument("appStateJson") { type = NavType.StringType },
//            navArgument("opcional") { type = NavType.StringType }
//        )
        ) {
//            val appStateJson = it.arguments?.getString("appStateJson") ?: ""
//            val opcional = it.arguments?.getString("opcional") ?: ""
//            ContactDataActivityView(navController, appStateJson)

        //      ContactDataActivityView(navController)

        }
    }
}