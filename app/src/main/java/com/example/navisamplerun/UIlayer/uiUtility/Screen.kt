package com.example.navisamplerun.UIlayer.uiUtility

sealed class Screen(val route:String,val title:String="No Title"){
    object HomeScreen :Screen("main_screen","Main")
    object DetailScreen : Screen("detail_screen","Detail")

}
