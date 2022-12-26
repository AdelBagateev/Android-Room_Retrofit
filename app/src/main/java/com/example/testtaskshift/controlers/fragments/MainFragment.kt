package com.example.testtaskshift.controlers.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.example.testtaskshift.retrofit.RetrofitService
import com.example.testtaskshift.R
import com.example.testtaskshift.retrofit.Common
import com.example.testtaskshift.data.entity.CardInfo
import com.example.testtaskshift.data.entity.geoToString
import com.example.testtaskshift.data.entity.toStringInfo
import com.example.testtaskshift.databinding.FragmentMainBinding
import com.example.testtaskshift.data.repositories.CardInfoRepository
import com.example.testtaskshift.data.LocalCardInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment(R.layout.fragment_main)  {
    private var binding : FragmentMainBinding ?= null
    private var cardInfo : CardInfo?=null
    private var repository : CardInfoRepository?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding?.run {
            ivHistory.setOnClickListener {
                updateLocalRepo()
                navigateToHistoryFrag()
            }

            btnSendRequest.setOnClickListener {
                val bin : String = etBIN.text.toString();
                try {
                    bin.toLong()
                    sendRequest(bin)
                } catch (e : Exception) {
                    tvCardInfo.text = getString(R.string.not_exist)
                    tvGeo.text = ""
                }

            }
            tvGeo.setOnClickListener {
               redirectGeo()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        repository = null
    }

    private fun updateLocalRepo() {
        repository = CardInfoRepository(requireContext())
        var listCardsInfo : List<CardInfo>?

        lifecycleScope.launch(context = Dispatchers.IO) {

            listCardsInfo = repository?.getAllCardsInfo()

            listCardsInfo?.also {
                if (it.isNotEmpty()) {
                    for (i in it.indices) {
                        val id = it[i].id
                        it[i].bank = repository?.getBankById(id)
                        it[i].country = repository?.getCountryById(id)
                        it[i].number = repository?.getCardNumberById(id)
                    }
                    LocalCardInfoRepository.updateRepository(it)
                } else {
                    listCardsInfo = listOf(CardInfo(-1))
                    LocalCardInfoRepository.updateRepository(listCardsInfo!!)
                }
            }
        }
    }

    private fun sendRequest(bin:String) {
        val mService : RetrofitService = Common.retrofitService
        mService.getCardInformation(bin).enqueue(object : Callback<CardInfo> {

            override fun onFailure(call: Call<CardInfo>, t: Throwable) {
                binding?.tvCardInfo?.text = getString(R.string.error)
                binding?.tvGeo?.text = ""
            }

            override fun onResponse(
                call: Call<CardInfo>,
                response: Response<CardInfo>
            ) {
                if(response.body() == null) {
                    binding?.tvCardInfo?.text = getString(R.string.not_exist)
                    binding?.tvGeo?.text = ""
                } else {
                    cardInfo = response.body() as CardInfo
                    cardInfo?.number?.bin = bin
                    repository = CardInfoRepository(requireContext())

                    lifecycleScope.launch(context = Dispatchers.IO) {
                        cardInfo?.also {
                            repository?.saveCardInfo(it)
                            repository?.saveBank(it.bank!!)
                            repository?.saveCardNumber(it.number!!)
                            repository?.saveCountry(it.country!!)
                        }
                    }
                    updateLocalRepo()
                    binding?.tvCardInfo?.text = cardInfo?.toStringInfo()
                    binding?.tvGeo?.text = cardInfo?.country?.geoToString()
                }
            }
        })
    }

    private fun navigateToHistoryFrag() {
        val manager: FragmentManager = parentFragmentManager
        manager.beginTransaction()
            .replace(R.id.cont_main, HistoryFragment(),"MAIN_FRAG" )
            .addToBackStack("MAIN_FRAG")
            .commit()
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
//4276690017195154 4275690017195153 4295790007195153 4195710007195153