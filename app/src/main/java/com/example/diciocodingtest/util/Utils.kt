package com.example.diciocodingtest.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.example.diciocodingtest.domain.model.InfoOut
import java.io.ByteArrayOutputStream


object Utils {

    fun bitmapToBase64(bitmap: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 1, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.NO_WRAP)
    }

    suspend fun base64ToBitmap(base64String: String): Bitmap? {
        val decodedString: ByteArray = Base64
            .decode(base64String, Base64.DEFAULT)
        val decodedByte = BitmapFactory
            .decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    fun formatJsonString(infoOut: InfoOut): String {
        return "{\"calle\":\"${infoOut.street}\",\"numero\":\"${infoOut.number}\",\"colonia\":\"${infoOut.neighborhood}\",\"delegacion\":\"${infoOut.municipality}\",\"estado\":\"${infoOut.state}\",\"cp\":\"${infoOut.zipCode}\",\"imagen\":\"${infoOut.image}\"}"
    }

}