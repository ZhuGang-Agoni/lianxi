package com.zg.lianxi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingListFragment : Fragment() {

    private lateinit var rankingType: RankingType

    companion object {
        fun newInstance(type: RankingType): RankingListFragment {
            val fragment = RankingListFragment()
            fragment.rankingType = type
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ranking_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rankingRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val rankings = when(rankingType) {
            RankingType.OVERALL -> generateOverallRankings()
            RankingType.WEEKLY -> generateOverallRankings()
            RankingType.COMMUNITY -> generateOverallRankings()
        }

        recyclerView.adapter = RankingAdapter(rankings)

        // 添加图表
//        if (rankingType == RankingType.OVERALL) {
//            addCarbonTrendChart(view)
//        }
    }

//    private fun addCarbonTrendChart(view: View) {
//        val chart = view.findViewById<BarChart>(R.id.barChart)
//
//        // 模拟数据
//        val entries = listOf(
//            BarEntry(1f, 12.5f),
//            BarEntry(2f, 18.3f),
//            BarEntry(3f, 15.2f),
//            BarEntry(4f, 22.7f),
//            BarEntry(5f, 19.8f)
//        )
//
//        val dataSet = BarDataSet(entries, "月度减碳量(kg)")
//        dataSet.color = ContextCompat.getColor(requireContext(), R.color.green_primary)
//
//        val data = BarData(dataSet)
//        chart.data = data
//
//        // 图表样式设置
//        chart.description.isEnabled = false
//        chart.axisLeft.axisMinimum = 0f
//        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
//        chart.animateY(1000)
//        chart.invalidate()
//    }

    private fun generateOverallRankings(): List<RankingItem> {
        return listOf(
            RankingItem("user001", "碳先锋", 128.5, 1, false, BadgeType.TRANSPORT_HERO),
            RankingItem("user002", "绿地球", 115.2, 2, false, BadgeType.ENERGY_SAVER),
            RankingItem("user003", "环保达人", 98.7, 3, true, BadgeType.RECYCLING_CHAMP),
            RankingItem("user004", "节能卫士", 87.3, 4),
            RankingItem("user005", "回收专家", 76.5, 5)
        )
    }

    // 其他榜单数据生成方法类似...
}
