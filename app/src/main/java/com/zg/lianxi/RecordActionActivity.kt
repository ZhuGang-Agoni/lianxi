package com.zg.lianxi

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.zg.lianxi.databinding.ActivityRecordActionBinding

class RecordActionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecordActionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "记录低碳行为"

        // 设置分类选择
        setupCategorySelector()

        // 设置提交按钮
        binding.btnSubmit.setOnClickListener {
//            submitCarbonAction()
        }
    }

    private fun setupCategorySelector() {
        val categories = listOf(
            Triple(R.drawable.ic_launcher_background, "交通出行", "#4CAF50"),
            Triple(R.drawable.ic_launcher_background, "节能用电", "#FF9800"),
            Triple(R.drawable.ic_launcher_background, "绿色饮食", "#E91E63"),
            Triple(R.drawable.ic_launcher_background, "回收利用", "#2196F3"),
            Triple(R.drawable.ic_launcher_background, "环保购物", "#9C27B0"),
            Triple(R.drawable.ic_launcher_background, "其他行为", "#607D8B")
        )

//        val adapter = object : RecyclerView.Adapter<CategoryViewHolder>() {
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//                val view = LayoutInflater.from(parent.context)
//                    .inflate(R.layout.item_category, parent, false)
//                return CategoryViewHolder(view)
//            }
//
//            override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
//                val (iconRes, title, color) = categories[position]
//                holder.bind(iconRes, title, color)
//
//                holder.itemView.setOnClickListener {
//                    selectCategory(position, color)
//                }
//            }

//            override fun getItemCount() = categories.size
//        }
//
//        binding.rvCategories.layoutManager = GridLayoutManager(this, 3)
//        binding.rvCategories.adapter = adapter
    }
}
//    private fun selectCategory(position: Int, color: String) {
//        binding.selectedCategory.setCardBackgroundColor(Color.parseColor("${color}33")) // 添加透明度
//        binding.selectedCategory.visibility = View.VISIBLE
//
//        // 根据选择的类别显示不同表单
//        when(position) {
//            0 -> showTransportForm()
//            1 -> showTransportForm()
//            2 -> showTransportForm()
//            // ...其他类别
//        }
//    }

//    private fun showTransportForm() {
//        binding.formContainer.removeAllViews()
//        val formView = layoutInflater.inflate(R.layout.form_transport, binding.formContainer, false)
//
//        // 设置交通工具选择器
//        val spinner = formView.findViewById<MaterialAutoCompleteTextView>(R.id.spinnerVehicle)
//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_dropdown_item_1line,
//            resources.getStringArray(R.array.vehicles)
//        )
//        spinner.setAdapter(adapter)
//
//        // 距离输入监听
//        val etDistance = formView.findViewById<TextInputEditText>(R.id.etDistance)
//        etDistance.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                calculateCarbonReduction()
//            }
//            // 其他方法...
//        })
//
//        binding.formContainer.addView(formView)
//    }
//
//    private fun calculateCarbonReduction() {
//        // 获取表单数据
//        val distance = binding.etDistance.text.toString().toDoubleOrNull() ?: 0.0
//        val vehicleType = binding.spinnerVehicle.text.toString()
//
//        // 计算减碳量
//        val reduction = CarbonCalculator.calculateTransportReduction(
//            distance.toFloat(),
//            vehicleType
//        )
//
//        // 显示结果
//        binding.tvResult.text = "本次行为减少碳排放: %.2f kg".format(reduction)
//        binding.resultContainer.visibility = View.VISIBLE
//    }
//
//    private fun submitCarbonAction() {
//        // 验证数据
//        if (binding.etDistance.text.isNullOrEmpty()) {
//            showError("请输入距离")
//            return
//        }
//
//        // 创建行为对象
//        val action = CarbonAction(
//            userId = getCurrentUserId(),
//            actionType = "交通",
//            description = "乘坐${binding.spinnerVehicle.text}出行 ${binding.etDistance.text}公里",
//            carbonReduced = calculateCarbonReduction(),
//            timestamp = System.currentTimeMillis()
//        )
//
//        // 保存到数据库
//        CarbonRepository.saveAction(action)
//
//        // 显示成功消息
//        showSuccess("低碳行为已记录！获得${(action.carbonReduced * 10).toInt()}碳积分")
//
//        // 关闭Activity
//        finish()
//    }
//
//    private fun showSuccess(message: String) {
//        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
//            .setBackgroundTint(ContextCompat.getColor(this, R.color.green_primary))
//            .show()
//    }
//
//    private fun showError(message: String) {
//        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
//            .setBackgroundTint(ContextCompat.getColor(this, R.color.zi))
//            .show()
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        finish()
//        return true
//    }
//}