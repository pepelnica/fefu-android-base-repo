package ru.fefu.activitytracker.domain.entity


data class MyActivityEntity(
    override val distance: String,
    override val duration: String,
    override val activityType: String,
    override val timing: String,
): ActivityEntity