package com.zg.lianxi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeedAdapter(private val actions: List<CarbonAction>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        val userName: TextView = itemView.findViewById(R.id.tvUserName)
        val actionType: TextView = itemView.findViewById(R.id.tvActionType)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val carbonAmount: TextView = itemView.findViewById(R.id.tvCarbonAmount)
        val time: TextView = itemView.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carbon_action, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val action = actions[position]
        holder.avatar.setImageResource(action.userAvatar)
        holder.userName.text = action.userName
        holder.actionType.text = action.actionType
        holder.description.text = action.description
        holder.carbonAmount.text = "减少 ${action.carbonReduced}kg 碳"

        // 格式化时间
        val timeAgo = getTimeAgo(action.timestamp)
        holder.time.text = timeAgo
    }

    private fun getTimeAgo(timestamp: Long): String {
        // 实现时间差计算逻辑
        return "2小时前" // 简化实现
    }

    override fun getItemCount() = actions.size
}
