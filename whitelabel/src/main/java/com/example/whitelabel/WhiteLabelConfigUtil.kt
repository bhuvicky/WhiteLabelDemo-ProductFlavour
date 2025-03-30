package com.example.whitelabel


import android.content.Context
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.FileInputStream
import javax.inject.Inject

const val CONFIG_DIR = "config"
const val JSON_FILE_NAME = "raw/app_config.json"

class WhiteLabelConfigUtil(
//    @ApplicationContext private val context: Context
) {

    /*fun whiteLabelConfigUtil(): WhiteLabelConfiguration {

//        val inputStream = resources.openRawResource(R.raw.app_config)
//        val json = inputStream.bufferedReader().use { it.readText() }

        val fis = FileInputStream("$CONFIG_DIR/$JSON_FILE_NAME")
//        val json = context.assets.open("app_config.json").bufferedReader().use { it.readText() }
        val jsonString = fis
            .bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(json, WhiteLabelConfiguration::class.java)
    }*/

    fun getColorHexCode() = "#d9332e"
}
