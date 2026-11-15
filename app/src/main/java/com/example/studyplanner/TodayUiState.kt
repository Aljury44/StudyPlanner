
package com.example.studyplanner

data class TodayUiState(
    val isLoading: Boolean = true,
    val tasks: List<StudyTask> = emptyList(),
    val message: String? = null
)

