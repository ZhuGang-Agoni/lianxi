package com.zg.lianxi

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView : View {
    private var mColor = Color.RED
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context):super(context){
        init()
    }


    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet,0)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        val a: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CircleView)
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED)
        a.recycle()
        init()
    }

    private fun init() {
        mPaint.setColor(mColor)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200)
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSpecSize)
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 200)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paddingLeft = paddingLeft
        val paddingRight = paddingRight
        val paddingTop = paddingTop
        val paddingBottom = paddingBottom

        val width = width - paddingLeft - paddingRight
        val height = height - paddingTop - paddingBottom

        val radius = minOf(width, height) / 2

        canvas.drawCircle((paddingLeft + width / 2).toFloat(), (paddingTop + height / 2).toFloat(), radius.toFloat(), mPaint)
    }
}