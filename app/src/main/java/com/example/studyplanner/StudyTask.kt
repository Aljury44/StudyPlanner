
package com.example.studyplanner

data class StudyTask(
    val id: Int,
    val title: String,
    val course: String,
    val isDone: Boolean = false
)

