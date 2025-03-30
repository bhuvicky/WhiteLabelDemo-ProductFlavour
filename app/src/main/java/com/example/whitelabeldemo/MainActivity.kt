package com.example.whitelabeldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.example.whitelabel.WhiteLabelConfigUtil
import com.example.whitelabeldemo.ui.ImageTextSlider
import com.example.whitelabeldemo.ui.theme.WhiteLabelDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var util: WhiteLabelConfigUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhiteLabelDemoTheme {
                val s1 = stringResource(R.string.page1_txt_string)
                val s2 = stringResource(R.string.page2_txt_string)
                val s3 = stringResource(R.string.page3_txt_string)
                val sliderItems = listOf(
                    Pair(R.drawable.image1, s1),
                    Pair(R.drawable.image2, s2),
                    Pair(R.drawable.image3, s3),
                )


                val whitelabelConfigData = remember { mutableStateOf(WhiteLabelConfigUtil()) }
                ImageTextSlider(imagesWithText = sliderItems, whitelabelConfigData)
            }
        }
    }
}