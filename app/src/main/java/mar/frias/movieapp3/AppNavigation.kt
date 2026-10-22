package mar.frias.movieapp3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ){
        composable("login"){
            LoginScreen(
                onLoginOk = {
                    navController.navigate("movies"){
                        popUpTo("login") { inclusive = true }
                    }
                },
                onRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("movies") {
            MoviesScreen (
                onMovieClicked = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        )
        {   entrance ->
            val id = entrance.arguments?.getInt("id") ?: 1
            DetailScreen(
                movieId = id,
                onBack = { navController.popBackStack() }
            )
        }

        composable("register") {
            RegisterScreen (
                onRegisterOk = {
                    navController.navigate("movies") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onCancel = { navController.popBackStack() }
            )
        }

    }
}