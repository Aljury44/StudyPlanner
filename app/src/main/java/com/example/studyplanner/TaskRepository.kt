package com.example.studyplanner

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: StudyTaskDao) {

    val allTasks: Flow<List<StudyTask>> = dao.getAllTasks()

    suspend fun add(title: String, course: String) {
        dao.insert(StudyTask(title = title, course = course))
    }

    suspend fun setDone(task: StudyTask, done: Boolean) {
        dao.update(task.copy(isDone = done))
    }

    suspend fun delete(task: StudyTask) {
        dao.delete(task)
    }
}
