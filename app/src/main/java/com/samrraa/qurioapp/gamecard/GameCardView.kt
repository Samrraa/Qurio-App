package com.samrraa.qurioapp.gamecard

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import com.samrraa.qurioapp.R

class GameCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val view = inflate(context, R.layout.game_card, this)

    private val titleText: TextView = view.findViewById(R.id.textTitle)
    private val button: Button = view.findViewById(R.id.startGameButton)
    private val backgroundView: GameCardBackgroundView =
        view.findViewById(R.id.gameCardBackgroundView)

    init {
        setAttributeSet(attrs)
    }

    private fun setAttributeSet(attributes: AttributeSet?) {
        attributes?.let {
            context.withStyledAttributes(
                set = it,
                attrs = R.styleable.GameCardView,
                defStyleAttr = 0,
                defStyleRes = 0
            ) {
                runCatching {
                    val imageRes = getResourceId(R.styleable.GameCardView_cardImage, 0)
                    if (imageRes != 0) backgroundView.setImage(imageRes)

                    titleText.text = getString(R.styleable.GameCardView_cardTitle) ?: ""

                    button.apply {
                        text = getString(R.styleable.GameCardView_buttonText) ?: ""
                        layoutParams.height =
                            getDimensionPixelSize(R.styleable.GameCardView_buttonHeight, 0)
                    }

                    backgroundView.setBorderColor(
                        getColor(R.styleable.GameCardView_borderColor, Color.BLACK)
                    )
                }
            }
        }
    }

    fun setOnButtonClickListener(listener: (View) -> Unit) {
        button.setOnClickListener(listener)
    }
}
