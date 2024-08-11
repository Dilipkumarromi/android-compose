package com.example.mycomposeapplications.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun buttonNavigations(){
    var navigationControl= rememberNavController()
    var context=LocalContext.current.applicationContext
    var selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Green
            ) {
                IconButton(onClick = { selected.value=Icons.Default.Home
                navigationControl.navigate(Screens.Profile.screen){
                    //remove multiple back button
                    popUpTo(0)
                }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null,
                        modifier =Modifier.size(26.dp) ,
                        // color of icon
                        tint =if(selected.value==Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(6.dp),
                    contentAlignment = Alignment.Center
                ){
                    FloatingActionButton(onClick = { Toast.makeText (context,"Open",Toast.LENGTH_SHORT).show() }) {
                        Icon(Icons.Default.Add, contentDescription = null,
                            tint =if(selected.value==Icons.Default.PlayArrow) Color.White else Color.DarkGray
                        )
                    }
                }
                IconButton(onClick = { selected.value=Icons.Default.PlayArrow
                    navigationControl.navigate(Screens.MyCourse.screen){
                        //remove multiple back button
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null,
                        modifier =Modifier.size(26.dp) ,
                        // color of icon
                        tint =if(selected.value==Icons.Default.PlayArrow) Color.White else Color.DarkGray
                    )
                }

            }
        }
    ) {paddingValues ->  
        NavHost(navController = navigationControl,
            startDestination = Screens.Profile.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Profile.screen){ profile() }
            composable(Screens.Profile.screen){ myCourse() }
            composable(Screens.Profile.screen){ studentList() }
        }

    }
}