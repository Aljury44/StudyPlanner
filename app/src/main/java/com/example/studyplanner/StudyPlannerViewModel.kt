
package com.example.studyplanner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// CSC 402 - Lecture 6: Study Planner

data class StudyPlannerUiState(
    val tasks: List<String> = emptyList()
)

class StudyPlannerViewModel : ViewModel() {

    var uiState by mutableStateOf(StudyPlannerUiState())
        private set

    fun addTask(title: String) {
        // TODO 1 - Add a task only if it is not blank.
        if (title.isNotBlank()) {
            uiState = uiState.copy(
                tasks = uiState.tasks + title.trim()
            )
        }
    }
}
