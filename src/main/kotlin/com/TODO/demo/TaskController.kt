package com.TODO.demo


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class TaskController {
    // my initial tasks
    val tasks = mutableListOf(
        Task("1", "Apple",),
        Task("2", "Cheese"),
        Task("3", "Toast"),
        Task("4", "Water"),
    )

    @GetMapping
    fun listTask(): List<Task> {
        println("listing tasks...")
        return this.tasks
    }

    @PostMapping
    fun addTask(@RequestBody task: Task): Task {
        println("adding task...")
        // add to the list
        tasks.add(task)

        // return the added task only
        return task
    }

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable id: String,
        @RequestBody task: TaskUpdateRequest
    ): Task {
        var foundTask = tasks.find { task: Task -> task.id == id }

        if (foundTask === null) {
            println("Task with id $id not found...")
            throw Exception("Task with id $id not found...")
        }
        return foundTask
    }


    @PatchMapping("/{id}")
    fun updateTask(
        @PathVariable id: String,
        @RequestBody task: Task
    ): Task {
        var foundTask = tasks.find { task: Task -> task.id == id }
        println("adding task...")
        // add to the list
        tasks.add(task)


        if (foundTask === null) {
            println("Task with id $id not found...")
            throw Exception("Task with id $id not found...")
        }
        return (task)
    }


    @DeleteMapping("/{id}")
    fun deletTask(
        @PathVariable id: String,
        @RequestBody task: Task): Unit {
        var foundTask = tasks.find { task: Task -> task.id == id }
        println("deleting task...")
        tasks.remove(task)


        if (foundTask === null) {
            println("Task with id $id not found...")
            throw Exception("Task with id $id not found...")
        }
    }}




