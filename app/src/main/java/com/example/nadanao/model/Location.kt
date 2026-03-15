package com.example.nadanao.model

import android.content.Context
import android.location.Geocoder
import java.util.Locale

fun getPlaceName(context: Context, lat: Double, lon: Double): String? {

    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(lat, lon, 1)

    return addresses?.firstOrNull()?.let { address ->
        address.locality
            ?: address.subAdminArea
            ?: address.adminArea
    }
}