
package com.example.studyplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

                    // Lab 5 - Home screen
                    composable("home") {
                        Box(modifier = Modifier.fillMaxSize()) {

                            PlannerHomeRoute(
                                onTaskClick = { taskTitle ->
                                    navController.navigate(
                                        "detail/${android.net.Uri.encode(taskTitle)}"
                                    )
                                }
                            )

                            // Lab 6 button - always visible
                            Button(
                                onClick = {
                                    navController.navigate("lab6")
                                },
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 24.dp)
                            ) {
                                Text("Add Study Tasks ")
                            }
                        }
                    }

                    // Lab 5 - Task detail screen
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

                    // Lab 6 - Add a task screen
                    composable("lab6") {
                        StudyPlannerRoute()
                    }
                }
            }
        }
    }
}
