package com.example.testtaskshift.controlers.fragments

import android.os.Bundle
import android.view.View
import com.example.testtaskshift.data.entity.CardInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskshift.R
import com.example.testtaskshift.adapter.CardInfoAdapter
import com.example.testtaskshift.adapter.SpaceItemDecorator
import com.example.testtaskshift.databinding.FragmentHistoryBinding
import com.example.testtaskshift.data.LocalCardInfoRepository

class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var adapter : CardInfoAdapter ?= null
    private var binding : FragmentHistoryBinding ?= null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHistoryBinding.bind(view)

        binding?.run {

            val itemDecoration = context?.let {
                SpaceItemDecorator(
                    it,
                    16.0f
                )
            }
            val rvList : List<CardInfo> = getCardsList().asReversed()
            adapter = CardInfoAdapter(
                rvList
            )
            {
                navigateToInfoFrag(it)
            }
            rvCardsInfo.adapter = adapter
            rvCardsInfo.layoutManager = LinearLayoutManager(context)
            rvCardsInfo.addItemDecoration(itemDecoration!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter = null
        binding = null
    }

    private fun getCardsList() :List<CardInfo> {
        if(LocalCardInfoRepository.cardsInfo.isEmpty())
            return getCardsList()
        else if( LocalCardInfoRepository.cardsInfo[0].id == -1) {
            return listOf()
        }
        return LocalCardInfoRepository.cardsInfo
    }

    private fun navigateToInfoFrag(cardInfo: CardInfo) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out,
            )
            .replace(R.id.cont_main, InfoFragment.newInstance(cardInfo.id))
            .addToBackStack("list")
            .commit()
    }
}
