package github.com.st235.expandablebottonbar

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.ColorUtils
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar
import github.com.st235.lib_expandablebottombar.ExpandableBottomBarMenuItem
import android.view.ViewAnimationUtils
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color: View = findViewById(R.id.color)
        val bottomBar: ExpandableBottomBar = findViewById(R.id.expandable_bottom_bar)

        color.setBackgroundColor(ColorUtils.setAlphaComponent(Color.GRAY, 60))

        bottomBar.addItems(
                ExpandableBottomBarMenuItem.Builder()
                        .addItem(R.id.icon_home, R.drawable.ic_bug, R.string.text, Color.GRAY)
                        .addItem(R.id.icon_go, R.drawable.ic_gift, R.string.text2, Color.parseColor("#ff77a9"))
                        .addItem(R.id.icon_left, R.drawable.ic_one, R.string.text3, Color.parseColor("#58a5f0"))
                        .addItem(R.id.icon_right, R.drawable.ic_two, R.string.text4, Color.parseColor("#be9c91"))
                        .build()
        )

        bottomBar.onItemClickListener = { v, i ->
            val anim = ViewAnimationUtils.createCircularReveal(color, bottomBar.x.toInt()
                    + v.x.toInt(), bottomBar.y.toInt() + v.y.toInt(), 0F, findViewById<View>(android.R.id.content).height.toFloat())
            color.setBackgroundColor(ColorUtils.setAlphaComponent(i.activeColor, 60))
            anim.duration = 420
            anim.start()
        }
    }
}
