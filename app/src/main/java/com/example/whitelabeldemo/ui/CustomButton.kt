package com.example.whitelabeldemo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Blue,   // Default Blue
    textColor: Color = Color.White,        // Default White
    borderColor: Color = Color.Transparent,      // Default Border Color
    borderWidth: Int = 2,
    cornerRadius: Int = 12,                // Default Rounded Corners (12.dp)
    fontSize: Int = 18,                    // Default Font Size (18.sp)
    fontWeight: FontWeight = FontWeight.Bold // Default Bold Text
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(cornerRadius.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = textColor
        ),
        border = BorderStroke(borderWidth.dp, borderColor),
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(0.8f) // Adjust width if needed
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            style = TextStyle(color = textColor)
        )
    }
}