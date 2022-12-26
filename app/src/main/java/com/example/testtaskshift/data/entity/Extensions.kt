package com.example.testtaskshift.data.entity

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan

fun CardInfo.toStringInfo(): String {
    val isNull = "no info"
    return  "number: \n" +
            "    length: ${number?.length ?: isNull}\n" +
            "    luhn: ${number?.luhn?: isNull}\n" +
            "scheme: ${scheme?: isNull}\n" +
            "type: ${type?: isNull} \n" +
            "brand: ${brand?: isNull}\n" +
            "prepaid: ${prepaid?: isNull}\n" +
            "country: \n" +
            "    numeric: ${country?.numeric?: isNull}\n" +
            "    alpha2: ${country?.alpha2?: isNull}\n" +
            "    name: ${country?.name?: isNull}\n" +
            "    emoji: ${country?.emoji?: isNull}\n" +
            "    currency: ${country?.currency?: isNull}\n" +
            "    coordinates: ${country?.latitude ?: ""}, ${country?.longitude?: ""}" + "\n"+
            "bank: \n" +
            "    name: ${bank?.name?: isNull} \n" +
            "    url: ${bank?.url ?: isNull} \n" +
            "    phone: ${bank?.phone ?: isNull} \n" +
            "    city: ${bank?.city ?: isNull}\n"
}

fun Country.geoToString() : SpannableString {
    val latitude = latitude.toString()
    val longitude = longitude.toString()
    val content = SpannableString("geoposition of county: $latitude, $longitude")
    content.setSpan(UnderlineSpan(), 23, content.length, 0)
    content.setSpan( ForegroundColorSpan(Color.parseColor("#03dac5")), 23, content.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return content
}
