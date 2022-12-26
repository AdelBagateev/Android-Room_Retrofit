package com.example.testtaskshift.controlers.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.testtaskshift.R
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.data.entity.geoToString
import com.example.testtaskshift.data.entity.toStringInfo
import com.example.testtaskshift.databinding.FragmentInfoBinding
import com.example.testtaskshift.data.LocalCardInfoRepository

class InfoFragment:Fragment(R.layout.fragment_info) {
    private var binding : FragmentInfoBinding ?= null
    private val cardsInfo = LocalCardInfoRepository.cardsInfo
    private var cardInfo : CardInfo? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentInfoBinding.bind(view)

        val cardInfoID = arguments?.getInt(ARG_NAME)

        cardInfoID?.apply {
            cardInfo =  cardsInfo.find { it.id == this }
        }

        binding?.run {
            tvMainInfo.text = cardInfo?.toStringInfo()
            tvGeo.text = cardInfo?.country?.geoToString()
        }

        binding?.run {
            tvGeo.setOnClickListener {
                redirectGeo()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    companion object {
        private const val ARG_NAME = "id"
        fun newInstance(id: Int) = InfoFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_NAME, id)
            }
        }
    }
    private fun redirectGeo() {
        val latitude = cardInfo?.country?.latitude
        val longitude = cardInfo?.country?.longitude
        if(latitude != null && longitude != null ) {
            val intent = Intent()
            intent.run {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo: $latitude, $longitude")
            }
            startActivity(intent)
        }
    }
}
