package com.mentoria.todochallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel : ViewModel(){
    var tasksItems = MutableLiveData<MutableList<TaskItem>>()

    init {
        //to initialize a list
        tasksItems.value = mutableListOf()
    }

    fun addTaskItem(newTask: TaskItem){
        var list = tasksItems.value
        //!! because the list isn't null
        list!!.add(newTask)
        tasksItems.postValue(list)
    }

    fun removeTaskItem(taskItem: TaskItem){
        var list = tasksItems.value
        list!!.remove(taskItem)
        tasksItems.postValue(list)
    }

    fun updateTaskItem( id: UUID = UUID.randomUUID(), name: String, desc: String, time: LocalTime?){
        var list = tasksItems.value
        var task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc
        task.time = time
        tasksItems.postValue(list)
    }

    fun setComplete(taskItem: TaskItem){
        var list = tasksItems.value
        var task = list!!.find { it.id == taskItem.id }!!
        if(task.completedDate == null) {
            //Check the API
            task.completedDate = LocalDate.now()
        }

        tasksItems.postValue(list)
    }

}