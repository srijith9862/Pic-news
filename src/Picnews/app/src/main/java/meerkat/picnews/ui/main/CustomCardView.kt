package meerkat.picnews.ui.main

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomCardView (context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    //constructor(context: Context, attrs: AttributeSet): super(context, attrs)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}