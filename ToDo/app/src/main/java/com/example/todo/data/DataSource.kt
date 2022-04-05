package com.example.todo.data

import com.example.todo.R
import com.example.todo.model.Task

class DataSource {

    fun loadTasks() : List<Task>{

        return listOf<Task>(
            Task(R.string.task1),
            Task(R.string.task2),
            Task(R.string.task3)
        )

    }

}