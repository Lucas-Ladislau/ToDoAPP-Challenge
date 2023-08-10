package com.mentoria.todochallenge

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskItem (
    var name: String,
    var desc: String,
    var time: LocalTime?,
    var completedDate: LocalDate?,
    var complete: Boolean?,
    var id: UUID = UUID.randomUUID()

){
}