package com.example.testtaskshift.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.databinding.ItemCardInfoBinding

class CardInfoItem(
    private val binding: ItemCardInfoBinding,
    private val action: (CardInfo) -> Unit,
) :  RecyclerView.ViewHolder(binding.root) {
    private var cardInfo: CardInfo? = null

    init {
        itemView.setOnClickListener {
            cardInfo?.also(action)
        }
    }

    fun OnBind(cardInfo: CardInfo) {
        with(binding) {
            tvNumber.text = "BIN : "+ cardInfo.number?.bin
            tvInfoId.text = cardInfo.id.toString()
            tvShortInfo.text = cardInfo.country?.name +" "+ cardInfo.country?.emoji
            root.setOnClickListener {
                action(cardInfo)
            }
        }
    }
}
