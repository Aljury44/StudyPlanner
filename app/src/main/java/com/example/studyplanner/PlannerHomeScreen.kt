
package com.example.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PlannerUiState(
    val greeting: String = "Welcome, Aljury!",
    val totalTasks: Int = 5,
    val completedTasks: Int = 0
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tasks = listOf(
        "Study Kotlin",
        "Complete Android Lab",
        "Review Lecture Notes"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Study Planner",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = uiState.greeting,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Study Progress",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done"
        )

        Button(
            onClick = onCompleteTask,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Complete a Task")
        }

        Text(
            text = "Study Tasks",
            style = MaterialTheme.typography.titleLarge
        )

        tasks.forEach { task ->
            Button(onClick = { onTaskClick(task) }) {
                Text(task)
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit = {}
) {
    var uiState by remember {
        mutableStateOf(PlannerUiState())
    }

    PlannerHomeScreen(
        uiState = uiState,
        onCompleteTask = {
            if (uiState.completedTasks < uiState.totalTasks) {
                uiState = uiState.copy(
                    completedTasks = uiState.completedTasks + 1
                )
            }
        },
        onTaskClick = onTaskClick
    )
}

@Preview(showBackground = true, name = "No Tasks Completed")
@Composable
private fun PlannerHomePreview1() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome, Aljury!",
                totalTasks = 5,
                completedTasks = 0
            ),
            onCompleteTask = {},
            onTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "All Tasks Completed")
@Composable
private fun PlannerHomePreview2() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Great job, Aljury!",
                totalTasks = 5,
                completedTasks = 5
            ),
            onCompleteTask = {},
            onTaskClick = {}
        )
    }
}
