
package com.example.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskDetailScreen(
    taskTitle: String,
    onShare: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Task Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = taskTitle,
            style = MaterialTheme.typography.titleLarge
        )

        Button(onClick = onShare) {
            Text("Share")
        }

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true, name = "Task Detail Preview 1")
@Composable
private fun TaskDetailPreview1() {
    MaterialTheme {
        TaskDetailScreen(
            taskTitle = "Study Kotlin",
            onShare = {},
            onBack = {}
        )
    }
}

@Preview(showBackground = true, name = "Task Detail Preview 2")
@Composable
private fun TaskDetailPreview2() {
    MaterialTheme {
        TaskDetailScreen(
            taskTitle = "Complete Android Lab",
            onShare = {},
            onBack = {}
        )
    }
}
