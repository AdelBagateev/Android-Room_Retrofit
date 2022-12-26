package com.example.testtaskshift.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.databinding.ItemCardInfoBinding


class CardInfoAdapter (
    private val list: List<CardInfo>,
    private val action: (CardInfo) -> Unit,
) : RecyclerView.Adapter<CardInfoItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardInfoItem = CardInfoItem(
        binding = ItemCardInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
            false
        ),
        action = action
        )

    override fun onBindViewHolder(
        holder: CardInfoItem,
        position: Int
    ) {
        holder.OnBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}