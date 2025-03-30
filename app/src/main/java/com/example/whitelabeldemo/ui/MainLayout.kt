package com.example.whitelabeldemo.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whitelabel.WhiteLabelConfigUtil
import com.example.whitelabel.WhiteLabelConfiguration
import com.example.whitelabeldemo.R


@Composable
fun ImageTextSlider(imagesWithText: List<Pair<Int, String>>, whitelabelConfigData: MutableState<WhiteLabelConfigUtil>) {
    val pagerState = rememberPagerState(pageCount = { imagesWithText.size } )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(whitelabelConfigData.value.parseColorFromJson()),
            verticalAlignment = Alignment.Top
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = imagesWithText[page].first),
                    contentDescription = "Image $page",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dots Indicator
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(imagesWithText.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(4.dp)
                        .then(
                            Modifier
                                .background(
                                    color = if (isSelected) Color.Blue else Color.Gray,
                                    shape = CircleShape
                                )
                        )
                )
            }
        }
        /*HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            activeColor = MaterialTheme.colorScheme.primary,
            inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            indicatorShape = CircleShape
        )*/

        Spacer(modifier = Modifier.height(16.dp))

        // Dynamic Text (Changes with Slide)
        Text(
            text = imagesWithText[pagerState.currentPage].second,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold,
                fontSize = 24.sp),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            CustomButton(
                text = "Create Account",
                onClick = { /* Handle Click */ },
                backgroundColor = colorResource(R.color.purple_700),  // Change Background Color
//                backgroundColor = colorResource(R.color.purple_700_Color_In_Main),  // Change Background Color
                textColor = colorResource(R.color.white),     // Change Text Color
                cornerRadius = 25,            // Change Corner Radius
                fontSize = 20,                // Change Font Size
                fontWeight = FontWeight.Medium // Change Font Weight
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                text = "Login",
                onClick = { /* Handle Click */ },
                backgroundColor = colorResource(R.color.white),  // Change Background Color
                textColor = colorResource(R.color.gray),     // Change Text Color
                cornerRadius = 25,            // Change Corner Radius
                fontSize = 20,                // Change Font Size
                fontWeight = FontWeight.Medium, // Change Font Weight
                borderColor = colorResource(R.color.black),
                borderWidth = 1
            )

            Spacer(modifier = Modifier.height(50.dp))

            CustomButton(
                text = "Find Near Chargers",
                onClick = { /* Handle Click */ },
                backgroundColor = colorResource(R.color.gray),  // Change Background Color
                textColor = colorResource(R.color.white),     // Change Text Color
                cornerRadius = 15,            // Change Corner Radius
                fontSize = 20,                // Change Font Size
                fontWeight = FontWeight.Medium // Change Font Weight
            )


        }
    }
}

fun com.example.whitelabel.WhiteLabelConfigUtil.parseColorFromJson(): Color {
    return Color(android.graphics.Color.parseColor(this.getColorHexCode()))
}