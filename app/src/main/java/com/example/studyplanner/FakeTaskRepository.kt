package com.example.studyplanner
import kotlinx.coroutines.delay

class FakeTaskRepository {

    suspend fun loadTodayTasks(): List<StudyTask> {
        delay(1500L)
        return listOf(
            StudyTask(1, "Read Chapter 11", "Mobile Apps"),
            StudyTask(2, "Lab 8 report", "Mobile Apps"),
            StudyTask(3, "Revise SQL joins", "Databases")
        )
    }

    suspend fun setDone(id: Int, done: Boolean) {
        delay(300L)
    }
}
