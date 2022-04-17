package com.example.navisamplerun.UIlayer


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navisamplerun.UIlayer.uiUtility.Screen

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route=Screen.HomeScreen.route){
HomeScreen()
        }
        composable(route = Screen.DetailScreen.route){
            DetailScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { Bottombar(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }

}

@Composable
fun HomeScreen(){
    Text("On the Home Screen")
}
@Composable
fun DetailScreen(){
    Text("On the Detailed Screen")
}

@Composable
fun Bottombar(navController: NavController){
    val screens= listOf(Screen.HomeScreen,
        Screen.DetailScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentdestination=navBackStackEntry?.destination
    BottomNavigation{
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentdestination, navController =navController )
        }
    }

}
@Composable
fun RowScope.AddItem(screen: Screen,currentDestination:NavDestination?,navController:NavController){
    BottomNavigationItem(label={Text(text=screen.title)}, icon = {},selected = currentDestination?.hierarchy?.any{
        it.route==screen.route

    }==true, onClick = {
        navController.navigate(screen.route)
    })

}