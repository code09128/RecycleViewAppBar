package com.ezaio.recycleviewappbar

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_account.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    lateinit var accountAdapter: AccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setBackgroundColor(getColor(R.color.black))

        initSetView()
        initRecycleView()
    }

    /**控制設定的頁面動作*/
    private fun initSetView() {
        //計算滑動距離監聽
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.d("verticalOffset", verticalOffset.toString())
            Log.d("verticalOffset totalScrollRange", appBarLayout.totalScrollRange.toString())

            when {
                //收合狀態 (abs)絕對值
                abs(verticalOffset) >= appBarLayout.totalScrollRange -> {
                    toolBar_text.visibility = View.VISIBLE
                }
                //展開狀態
                verticalOffset == 0 -> {
                    toolBar_text.visibility = View.GONE
                    toolBar_text.text = "$92,527"
                }
            }
        })
    }

    private fun initRecycleView() {
        r_item.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        r_item.layoutManager = layoutManager
        layoutManager.reverseLayout = true //列表翻轉
        layoutManager.stackFromEnd = true //列表再底部開始展示，反轉後由上面開始展示

        accountAdapter = AccountAdapter(null, this)
        r_item.adapter = accountAdapter
    }
}