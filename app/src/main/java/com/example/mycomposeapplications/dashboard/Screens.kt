package com.example.mycomposeapplications.dashboard

sealed class Screens(val screen: String) {
   data object Profile:Screens(screen = "profile")
   data object AddStudent:Screens(screen = "addStudent")
   data object MyCourse:Screens(screen = "MyCourses")
   data object StudentList:Screens(screen = "StudentList")
}