package com.mentoria.todochallenge

import android.content.Context
import androidx.core.content.ContextCompat
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

    fun isCompleted() = completedDate != null
    fun imageResource(): Int = if(isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if(isCompleted()) green(context) else black(context)

    private fun green(context: Context) = ContextCompat.getColor(context, R.color.green)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)

}