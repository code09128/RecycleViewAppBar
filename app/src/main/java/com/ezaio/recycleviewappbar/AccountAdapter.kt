package com.ezaio.recycleviewappbar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * @auther dustin.hsieh
 * @Date on 2023/1/12
 * @Description
 */
class AccountAdapter(var data: MutableList<String>?, val context: Context) : BaseRecyclerAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trade_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val ivImgType = holder.getView<ImageView>(R.id.iv_imgType)
        val tvAmount = holder.getView<TextView>(R.id.tv_amountsList)
        val tvType = holder.getView<TextView>(R.id.tv_typeItem)
        val tvTime = holder.getView<TextView>(R.id.tv_time)
        val tvTradeType = holder.getView<TextView>(R.id.tv_tradeType)
        val tvListBackground = holder.getView<TextView>(R.id.tv_listBackground)

        tvTime.text = "2022/04/18 15:35"
        tvAmount.text = "720"
        tvType.text = "銷售"
        tvTradeType.text = "信用卡"
//        setView(holder, data!![position])
    }

    override fun getItemCount(): Int {
        return data?.size ?: 10
    }
}