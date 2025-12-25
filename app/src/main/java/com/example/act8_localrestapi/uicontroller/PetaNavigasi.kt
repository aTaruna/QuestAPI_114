package com.example.act8_localrestapi.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.act8_localrestapi.uicontroller.route.DestinasiEntry
import com.example.act8_localrestapi.uicontroller.route.DestinasiHome
import com.example.act8_localrestapi.view.DetailSiswaScreen
import com.example.act8_localrestapi.view.EntrySiswaScreen
import com.example.act8_localrestapi.view.HomeScreen
import com.example.myroomsiswa.view.route.DestinasiDetail

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier)
{
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route, modifier = Modifier){
        composable (DestinasiHome.route){
            HomeScreen(navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                navigateToItemUpdate = {navController.navigate("$DestinasiEntry.route}/${it}")})
        }
        composable (DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.navigate(DestinasiHome.route)})
        }
        composable (
            DestinasiDetail.routeWithArgs,arguments = listOf(navArgument(DestinasiDetail.itemIdArg)
        {
            type = NavType.IntType
        })
        ){
            DetailSiswaScreen(navigateToEditItem = {navController.navigate("${DestinasiEdit.route}/$it")
        },
                navigateBack = {navController.navigate(DestinasiHome.route)})
        }
        composable (DestinasiEdit.routeWithArgs, arguments = listOf(navArgument(DestinasiEdit.itemIdArg){
            type = NavType.IntType })){
            EditSiswaScreen(navigateBack = {navController.navigate(DestinasiHome.route)},
                onNavigateUp={navController.navigateUp()})
        }
    }
}