package com.sdm.fifteen

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.ViewGroup

class FifteenLayoutManager(context: Context) : GridLayoutManager(context, 4) {

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateDefaultLayoutParams())
    }

    override fun generateLayoutParams(c: Context, attrs: AttributeSet): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(c, attrs))
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(lp))
    }

    private fun spanLayoutSize(layoutParams: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        layoutParams.width = Math.round(getHorizontalSpace() / 4f)
        layoutParams.height = Math.round(getVerticalSpace() / 4f)
        return layoutParams
    }

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return false
    }

    private fun getHorizontalSpace(): Int {
        return width - paddingRight - paddingLeft
    }

    private fun getVerticalSpace(): Int {
        return height - paddingBottom - paddingTop
    }
}