package com.mentoria.todochallenge

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.mentoria.todochallenge.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
) : RecyclerView.ViewHolder(binding.root) {
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    fun bindTaskItem(taskItem: TaskItem){
        binding.name.text = taskItem.name

        if(taskItem.isCompleted()){
            binding.name.paintFlags = Paint .STRIKE_THRU_TEXT_FLAG
            binding.time.paintFlags = Paint .STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }

        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }

        binding.removeButton.setOnClickListener{
            clickListener.removeTaskItem(taskItem)
        }



        if(taskItem.time != null){
            binding.time.text = timeFormat.format(taskItem.time)
        }else{
            binding.time.text = ""
        }


    }
}