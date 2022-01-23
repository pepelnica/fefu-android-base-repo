package ru.fefu.activitytracker.domain.entity

data class UserActivityEntity(
    override val distance: String,
    override val duration: String,
    override val activityType: String,
    override val timing: String,
    val userTag: String
): ActivityEntity