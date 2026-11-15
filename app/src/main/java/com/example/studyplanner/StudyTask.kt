
package com.example.studyplanner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_tasks")
data class StudyTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val course: String,
    @ColumnInfo(name = "is_done")
    val isDone: Boolean = false
)
