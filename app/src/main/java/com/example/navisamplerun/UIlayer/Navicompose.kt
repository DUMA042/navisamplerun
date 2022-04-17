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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navisamplerun.UIlayer.uiUtility.Screen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route=Screen.MainScreen.route){
MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route){
            DetailScreen()
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
    Scaffold(bottomBar ={Bottombar(navController = navController)} ) {
        Text("On the main Screen")
    }

}
@Composable
fun DetailScreen(){
    Text("On the Detailed Screen")
}

@Composable
fun Bottombar(navController: NavController){
    val screens= listOf(Screen.MainScreen,
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