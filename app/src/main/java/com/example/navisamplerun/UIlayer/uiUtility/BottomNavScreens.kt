package com.example.navisamplerun.UIlayer.uiUtility

sealed class BottomNavScreens(val route: String,
                              val title:String

){
    object MainScreen :BottomNavScreens("main_screen","Main")
    object DetailScreen : BottomNavScreens("detail_screen","Detail")
}
