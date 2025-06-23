package com.zg.lianxi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.UUID

class FeedFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FeedAdapter
    private val carbonActions = mutableListOf<CarbonAction>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 初始化RecyclerView
        recyclerView = view.findViewById(R.id.feedRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 添加浮动打卡按钮
        val fab = view.findViewById<FloatingActionButton>(R.id.fabAddAction)
        fab.setOnClickListener {
            showActionDialog()
        }

        // 模拟数据
        loadSampleData()
        adapter = FeedAdapter(carbonActions)
        recyclerView.adapter = adapter
    }

    private fun showActionDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("记录低碳行为")
            .setItems(arrayOf("绿色出行", "节能用电", "减少浪费", "环保购物")) { _, which ->
                when (which) {
                    0 -> recordTransportAction()
                    1 -> recordTransportAction()
                    2 -> recordTransportAction()
                    3 -> recordTransportAction()
                }
            }
            .show()
    }

    private fun recordTransportAction() {
        // 实际应用中这里会有表单和计算逻辑
        val newAction = CarbonAction(
            id = UUID.randomUUID().toString(),
            userId = "user123",
            userName = "碳先锋",
            actionType = "交通",
            description = "骑自行车上班 8公里",
            carbonReduced = 1.8,
            timestamp = System.currentTimeMillis()
        )
        carbonActions.add(0, newAction)
        adapter.notifyItemInserted(0)
        recyclerView.smoothScrollToPosition(0)

        // 显示碳积分奖励
        showCarbonReward(1.8)
    }

    private fun showCarbonReward(amount: Double) {
        Snackbar.make(requireView(),
            "✓ 减少${amount}kg碳排放! 累计获得${amount * 10}碳积分",
            Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.green_primary))
            .show()
    }

    private fun loadSampleData() {
        carbonActions.addAll(listOf(
            CarbonAction("1", "user456", "绿地球", "饮食", "素食一日餐", 2.5, System.currentTimeMillis() - 3600000),
            CarbonAction("2", "user789", "回收达人", "回收", "旧衣物回收5kg", 3.2, System.currentTimeMillis() - 7200000),
            CarbonAction("3", "user101", "节能卫士", "能源", "空调调高1℃ 8小时", 1.2, System.currentTimeMillis() - 10800000)
        ))
    }
}