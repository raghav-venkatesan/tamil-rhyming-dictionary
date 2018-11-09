package ca.havensoft.tamilrhymingdictionary.ui.customviews

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Patrick Ivarsson on 7/18/17.
 */
class ItemOffsetDecoration(private val mSpacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mSpacing, mSpacing, mSpacing, mSpacing)
    }
}