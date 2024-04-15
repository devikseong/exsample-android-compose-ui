package com.devikseong.composeui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SlotAPIView(){
    Column {
        Text("TEST")
        SlotAPIContent1(content = { ButtonDemo() })
    }
}

@Composable
fun SlotAPIContent1(content: @Composable () -> Unit) {
    Column {
        content()
    }
}

@Composable
fun ButtonDemo() {
    Button(onClick = {}) {
        Text("Click Me")
    }
}