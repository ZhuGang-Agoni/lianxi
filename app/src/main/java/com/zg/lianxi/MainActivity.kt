package com.zg.lianxi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zg.lianxi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置底部导航
        setupBottomNavigation()

        // 默认显示动态页
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FeedFragment())
            .commit()
    }

    private fun setupBottomNavigation() {
        val navView: BottomNavigationView = binding.navView

        // 创建菜单项ID到Fragment的映射
        val fragmentMap = mapOf(
            R.id.navigation_feed to FeedFragment::class.java,
            R.id.navigation_ranking to RankingFragment::class.java,
            R.id.navigation_challenges to RankingFragment::class.java,
            R.id.navigation_profile to RankingFragment::class.java
        )

        // 设置导航项选择监听
        navView.setOnItemSelectedListener { item ->
            val fragmentClass = fragmentMap[item.itemId]
            fragmentClass?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, it.newInstance())
                    .commit()
                true
            } ?: false
        }

        // 设置默认选中的菜单项
        navView.selectedItemId = R.id.navigation_feed

        // 添加徽章通知
        setupBadge(navView)
    }

    private fun setupBadge(navView: BottomNavigationView) {
        // 成就徽章
        navView.getOrCreateBadge(R.id.navigation_challenges).apply {
            backgroundColor = ContextCompat.getColor(this@MainActivity, R.color.green_primary)
            badgeTextColor = ContextCompat.getColor(this@MainActivity, R.color.white)
            number = 3
            maxCharacterCount = 2
            isVisible = true
        }

        // 新消息徽章
        navView.getOrCreateBadge(R.id.navigation_profile).apply {
            backgroundColor = ContextCompat.getColor(this@MainActivity, R.color.zi)
            badgeTextColor = ContextCompat.getColor(this@MainActivity, R.color.white)
            number = 1223
            isVisible = true
        }
    }

    // 扩展函数：简化Fragment实例化
    private fun <T : Fragment> Class<T>.newInstance(): T {
        return newInstance() as T
    }
}
