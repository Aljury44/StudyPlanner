
package com.example.studyplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studyplanner.ui.theme.StudyPlannerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyPlannerTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        PlannerHomeRoute(
                            onTaskClick = { taskTitle ->
                                navController.navigate(
                                    "detail/${android.net.Uri.encode(taskTitle)}"
                                )
                            }
                        )
                    }

                    composable(
                        route = "detail/{taskTitle}",
                        arguments = listOf(
                            navArgument("taskTitle") {
                                type = NavType.StringType
                            }
                        )
                    ) { backStackEntry ->

                        val taskTitle =
                            backStackEntry.arguments
                                ?.getString("taskTitle")
                                .orEmpty()

                        TaskDetailScreen(
                            taskTitle = taskTitle,
                            onShare = {
                                val shareIntent = Intent(
                                    Intent.ACTION_SEND
                                ).apply {
                                    type = "text/plain"
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        taskTitle
                                    )
                                }

                                startActivity(
                                    Intent.createChooser(
                                        shareIntent,
                                        "Share Task"
                                    )
                                )
                            },
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
