package com.TODO.demo


data class Task(
    val id: String,
    val title: String,    //Titel der Aufgabe
    var iscompleted: Boolean= false // Status ob es erledigt ist, normal falsch
)

