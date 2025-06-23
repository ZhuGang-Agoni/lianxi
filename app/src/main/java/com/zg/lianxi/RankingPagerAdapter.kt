package com.zg.lianxi

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RankingPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // 4个榜单

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RankingListFragment.newInstance(RankingType.OVERALL)
            1 -> RankingListFragment.newInstance(RankingType.WEEKLY)
            else-> RankingListFragment.newInstance(RankingType.COMMUNITY)

        }
    }
}

// 排行榜类型
enum class RankingType { OVERALL, WEEKLY, COMMUNITY }