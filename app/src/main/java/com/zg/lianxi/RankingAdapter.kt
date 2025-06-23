package com.zg.lianxi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RankingAdapter(private val items: List<RankingItem>) :
    RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rank: TextView = itemView.findViewById(R.id.tvRank)
        val avatar: ImageView = itemView.findViewById(R.id.ivRankAvatar)
        val name: TextView = itemView.findViewById(R.id.tvRankName)
        val carbon: TextView = itemView.findViewById(R.id.tvCarbonTotal)
        val badge: ImageView = itemView.findViewById(R.id.ivBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ranking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.rank.text = "${item.rank}"
        holder.name.text = item.userName
        holder.carbon.text = "减碳 ${item.totalCarbonReduced}kg"

        // 设置成就徽章
        item.badge?.let {
            holder.badge.visibility = View.VISIBLE
            holder.badge.setImageResource(when(it) {
                BadgeType.TRANSPORT_HERO -> R.drawable.ic_launcher_background
                BadgeType.ENERGY_SAVER -> R.drawable.ic_launcher_background
                BadgeType.RECYCLING_CHAMP -> R.drawable.ic_launcher_background
                BadgeType.WEEKLY_STAR -> R.drawable.ic_launcher_background
            })
        } ?: run {
            holder.badge.visibility = View.GONE
        }

        // 高亮当前用户
        if (item.isCurrentUser) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context, R.color.highlight_background))
        }
    }

    override fun getItemCount() = items.size
}
