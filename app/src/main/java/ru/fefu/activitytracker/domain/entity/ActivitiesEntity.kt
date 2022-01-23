package ru.fefu.activitytracker.domain.entity


data class ActivitiesEntity(
    val date: String,
    val activity: List<ActivityEntity>
)