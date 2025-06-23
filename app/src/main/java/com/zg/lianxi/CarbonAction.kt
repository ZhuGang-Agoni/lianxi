package com.zg.lianxi

data class CarbonAction(
    val id: String,
    val userId: String,
    val userName: String,
    val actionType: String, // 行为类型：交通、饮食、能源等
    val description: String,
    val carbonReduced: Double, // 减少的碳排放量(kg)
    val timestamp: Long,
    val userAvatar: Int = R.drawable.ic_launcher_background// 头像资源
)