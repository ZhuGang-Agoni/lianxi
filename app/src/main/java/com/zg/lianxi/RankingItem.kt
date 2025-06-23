package com.zg.lianxi

data class RankingItem(
    val userId: String,
    val userName: String,
    val totalCarbonReduced: Double,
    val rank: Int,
    val isCurrentUser: Boolean = false,
    val badge: BadgeType? = null // 成就徽章
)
enum class BadgeType {
    TRANSPORT_HERO, ENERGY_SAVER, RECYCLING_CHAMP, WEEKLY_STAR
}
