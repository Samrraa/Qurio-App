package com.samrraa.qurioapp.gamecard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.withClip
import com.samrraa.qurioapp.R

class GameCardBackgroundView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var borderColor: Int = Color.BLACK
    private var cardImageResId: Int = 0
    private val imageView: ImageView
    private val strokeDp: Float = 3f
    private val shadowRadiusDp: Float = 8f

    fun setBorderColor(color: Int) {
        borderColor = color
        applyBorderStyle()
        applyGlowBackground()
        invalidate()
    }

    fun setImage(resId: Int) {
        cardImageResId = resId
        imageView.setImageResource(cardImageResId)
    }

    private val borderPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = strokeDp.toPx()
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.game_card_background_view, this, true)
        imageView = findViewById(R.id.cardImage)
        applyBorderStyle()
        applyGlowBackground()
        setupView()
        setWillNotDraw(false)
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    private fun applyBorderStyle() {
        borderPaint.color = borderColor
        val shadowColor = ColorUtils.setAlphaComponent(borderColor, (0.6f * 255).toInt())
        borderPaint.setShadowLayer(shadowRadiusDp.toPx(), 0f, 0f, shadowColor)
    }

    private fun applyGlowBackground() {
        val gradient = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                ColorUtils.setAlphaComponent(borderColor, 0),
                ColorUtils.setAlphaComponent(borderColor, (0.8f * 255).toInt())
            )
        ).apply { shape = GradientDrawable.RECTANGLE }

        findViewById<View>(R.id.glowView).background = gradient
    }

    private fun setupView() {
        if (cardImageResId != 0) imageView.setImageResource(cardImageResId)
    }

    override fun dispatchDraw(canvas: Canvas) {
        val widthFloat = width.toFloat()
        val heightFloat = height.toFloat()

        if (widthFloat == 0f || heightFloat == 0f) {
            super.dispatchDraw(canvas)
            return
        }

        val halfStroke = borderPaint.strokeWidth / 2f

        val cornerInsetDp = 20f
        val bottomCornerInsetDp = 15f
        val cornerInsetPx = cornerInsetDp.toPx()
        val bottomCornerInsetPx = bottomCornerInsetDp.toPx()

        val clipPath = createCardPath(
            width = widthFloat,
            height = heightFloat,
            topCut = cornerInsetPx,
            bottomCut = bottomCornerInsetPx,
            padding = halfStroke
        )

        canvas.withClip(clipPath) {
            super.dispatchDraw(this)
        }

        canvas.drawPath(clipPath, borderPaint)
    }

    private fun createCardPath(
        width: Float,
        height: Float,
        topCut: Float,
        bottomCut: Float,
        padding: Float
    ): Path {
        val tilt = 6f

        return Path().apply {
            reset()
            moveTo(topCut + padding, padding)
            lineTo(width - topCut - padding, padding)
            lineTo(width - padding, topCut + padding)
            lineTo(width - bottomCut * 0.5f - padding - tilt, height - bottomCut - padding)
            lineTo(width - bottomCut - padding - tilt, height - padding)
            lineTo(bottomCut + padding + tilt, height - padding)
            lineTo(bottomCut * 0.5f + padding + tilt, height - bottomCut - padding)
            lineTo(padding, topCut + padding)
            close()
        }
    }

    private fun Float.toPx(): Float = this * resources.displayMetrics.density
}
