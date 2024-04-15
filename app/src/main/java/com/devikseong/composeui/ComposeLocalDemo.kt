package com.devikseong.composeui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

val LocalColor = staticCompositionLocalOf { Color(0xFFffdbcf) }

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Composable1() {

    var color = if(isSystemInDarkTheme()) {
        Color(0xFFa08d87)
    } else {
        Color(0xFFffdbcf)
    }

    Column {
        Composable2()

        CompositionLocalProvider(LocalColor provides color) {
            Composable3()
        }
    }
}

@Composable
fun Composable2() {
    Composable4()
}

@Composable
fun Composable3() {
    Composable5()
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {
    CompositionLocalProvider(LocalColor provides Color.Green) {
        Composable7()
    }

    Composable8()
}

@Composable
fun Composable6() {
    Text("Composable 6")
}

@Composable
fun Composable7() {
    Text("Composable 7", modifier = Modifier.background(LocalColor.current))
}

@Composable
fun Composable8() {
    Text("Composable 8", modifier = Modifier.background(LocalColor.current))
}