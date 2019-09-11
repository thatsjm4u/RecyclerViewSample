package `in`.teardown.soft.recyclerview

import `in`.teardown.soft.recyclerview.adapter.ItemAdapter
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.widget.FrameLayout
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fab_layout.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    var fabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = ArrayList<String>()
        for (i in 0 until 50)
            itemList.add("I'm all-over looking for you B...E...A...U...tiful Lady.")
        recyclerView.adapter = ItemAdapter(itemList, this)

//        fab.setOnClickListener { view ->
//            if (fabOpen) hideFABMenu() else showFABMenu()
//            fabOpen = !fabOpen;
////            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.actionListView -> {
                recyclerView.layoutManager = LinearLayoutManager(this)
                true
            }
            R.id.actionGridView -> {
                recyclerView.layoutManager = GridLayoutManager(this,2)
                true
            }
            R.id.actionStaggeredGrid -> {
                recyclerView.layoutManager = StaggeredGridLayoutManager(2, 0)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
/*
    fun showFABMenu() {
        val layoutParams = fab1.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab1.getWidth() * 1.7).roundToInt()
        layoutParams.bottomMargin += (fab1.getHeight() * 0.25).roundToInt()
        fab1.setLayoutParams(layoutParams)
        fab1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.show_fab_1))
        fab1.setClickable(true)
    }

    fun hideFABMenu() {
        val layoutParams = fab1.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab1.width * 1.7).roundToInt()
        layoutParams.bottomMargin -= (fab1.height * 0.25).roundToInt()
        fab1.layoutParams = layoutParams
        fab1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.hide_fab_1))
        fab1.isClickable = false
    }*/
}