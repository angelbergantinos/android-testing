package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("The title", "Description of my task", isCompleted = false)
        )

        // Call your function
        var result = getActiveAndCompletedStats(tasks)

        // Check the result using hamcrest
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun given_task_list_when_one_completed_and_no_active_tasks_then_hundred_and_zero_percentage() {
        // Create a completed task
        val tasks = listOf<Task>(
                Task("The title", "Description of my task", isCompleted = true)
        )

        // Call your function
        var result = getActiveAndCompletedStats(tasks)

        // Check the result using hamcrest
        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun given_task_list_when_two_completed_and_three_active_tasks_then_forty_and_sixty_percentage() {
        // Create 2 completed and 3 active tasks
        val tasks = listOf<Task>(
                Task("The title", "Description of my task", isCompleted = true),
                Task("The title 2", "Description of my task 2", isCompleted = false),
                Task("The title 3", "Description of my task 3", isCompleted = true),
                Task("The title 4", "Description of my task 4", isCompleted = false),
                Task("The title 5", "Description of my task 5", isCompleted = false)
        )

        // Call your function
        var result = getActiveAndCompletedStats(tasks)

        // Check the result using hamcrest
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

}

