package com.mentoria.todochallenge

interface TaskItemClickListener {

    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)

    fun removeTaskItem(taskItem: TaskItem)
}