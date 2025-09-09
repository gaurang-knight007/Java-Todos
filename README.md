# To-Do List Application (Java GUI)

A simple To-Do List application with a graphical user interface built using Java Swing. Easily add, start, finish, and delete tasks, with automatic saving and loading of your task list.

## Features

- Add new tasks with descriptions
- Start and finish tasks, tracking timestamps
- Delete tasks
- All tasks are saved and loaded automatically
- User-friendly GUI with table view

## Folder Structure

- `src/` - Java source files ([Main.java](src/Main.java), [Task.java](src/Task.java), [TaskManager.java](src/TaskManager.java), [FileHandler.java](src/FileHandler.java), [ToDoAppGUI.java](src/ToDoAppGUI.java))
- `bin/` - Compiled `.class` files and saved tasks
- `lib/` - External libraries (if any)
- `.vscode/` - VS Code settings

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- [Visual Studio Code](https://code.visualstudio.com/) with Java extensions (recommended)

### Build & Run

1. **Compile the project:**
    ```sh
    javac -d bin src/*.java
    ```
2. **Run the application:**
    ```sh
    java -cp bin Main
    ```

### Usage

- Enter a task description and click **Add**.
- Select a task and click **Start** to record the start time.
- Click **Finish** to mark a task as completed.
- Click **Delete** to remove a task.
- Tasks are saved automatically when you close the application.

## Code Overview

- [`Main`](src/Main.java): Entry point, initializes the GUI.
- [`Task`](src/Task.java): Represents a single to-do item.
- [`TaskManager`](src/TaskManager.java): Manages the list of tasks.
- [`FileHandler`](src/FileHandler.java): Handles saving/loading tasks.
- [`ToDoAppGUI`](src/ToDoAppGUI.java): The Swing-based GUI.

## License

This project is for educational purposes.