# StudyPlanner

StudyPlanner is an Android application developed for the CSC402 Mobile Application Programming course. It helps students view study tasks, track their study progress, navigate between screens, and add new tasks.

The application is built using Kotlin and Jetpack Compose. Its features have been developed progressively through course assignments.

## Current Features

### Study Planner Home Screen
- Displays a welcome message and study progress.
- Shows the number of completed tasks out of five.
- Includes a button to update task completion progress.
- Displays three predefined study tasks.

### Task Details and Navigation (Lab 5)
- Allows users to select a study task and open its detail screen.
- Passes the selected task title between screens using Navigation Compose.
- Provides a Back button to return to the home screen.
- Includes a Share button that opens Android's system share sheet using an implicit intent.

### Add Study Tasks (Lecture 6)
- Provides a separate screen for entering new study tasks.
- Allows users to add tasks using a text field and an Add button.
- Displays the added tasks in a list.
- Automatically updates the task count when a task is added.
- Uses a ViewModel to manage the task list and update the interface.
- Uses `rememberSaveable` to preserve the input text during configuration changes, such as screen rotation.

The predefined tasks on the home screen and the tasks added through the new task screen are currently managed separately.

## Application Architecture

The application follows a separation between UI presentation and state management.

- **Screen:** Displays the interface using Jetpack Compose.
- **Route:** Connects state and user events to the screen.
- **ViewModel:** Manages the dynamically added task list.
- **Navigation:** Handles movement between the home, task detail, and task entry screens.

State flows down to UI components, while user events are passed upward through callback functions.

## Technologies Used

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose
- Android ViewModel
- `rememberSaveable`
- Android Intents
- Android Studio
- Git and GitHub

## Screenshots

Application screenshots are available in the `.docs/Screenshots` folder, including the home screen, task details, sharing functionality, and task entry screen.

## Development and Testing

The application was developed and tested using Android Studio and an Android emulator. The home screen, navigation, task sharing, and task addition features were tested during development.

## AI Use

**Tool:** ChatGPT

**Usage:** ChatGPT was used to assist with understanding course concepts, resolving development issues, and reviewing implementation steps.

**Review and Testing:** The application was run and tested in Android Studio. Changes were reviewed during development, and the project was maintained through GitHub.
