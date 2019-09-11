package `in`.teardown.soft.recyclerview.widgets

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.StringBuilder
import android.view.animation.LinearInterpolator
import android.opengl.ETC1.getHeight
import androidx.core.view.ViewCompat.animate
import android.R.attr.translationY
import android.R.attr.start
import androidx.core.view.ViewCompat.animate
import android.R.attr.translationY
import android.R.attr.start





public class FABHideOnScroll(context: Context?, attrs: AttributeSet?) : FloatingActionButton.Behavior(context, attrs) {

    private val TAG = "FABHideOnScroll"

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        val layoutParams = child.layoutParams as CoordinatorLayout.LayoutParams
        val fab_bottomMargin = layoutParams.bottomMargin
        child.animate().translationY((child.height + fab_bottomMargin).toFloat())
            .setInterpolator(LinearInterpolator())
            .start()

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(
            coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type
        )
    }

    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        type: Int
    ) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type)
        child.animate().translationY(0f).setInterpolator(LinearInterpolator()).start()
    }
}