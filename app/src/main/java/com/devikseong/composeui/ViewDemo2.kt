package com.devikseong.composeui

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DemoTest2View() {
    MyTextField()
}

@Composable
fun MyTextField() {
    val textState = remember{ mutableStateOf("") }

    val onTextChnage = { text: String ->
        textState.value = text
    }

    TextField(
        value = textState.value,
        onValueChange = onTextChnage
    )
}
