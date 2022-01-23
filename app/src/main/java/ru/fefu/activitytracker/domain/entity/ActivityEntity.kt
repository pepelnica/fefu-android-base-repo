package ru.fefu.activitytracker.domain.entity


interface ActivityEntity {
    val distance: String
    val duration: String
    val activityType: String
    val timing: String
}