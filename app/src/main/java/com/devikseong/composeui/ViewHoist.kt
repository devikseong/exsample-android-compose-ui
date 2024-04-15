package com.devikseong.composeui

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun ViewA() {
    var switchState by remember { mutableStateOf(true) }

    val onSwitchChange = { value: Boolean ->
        switchState = value
    }

    ViewB(switchState, onSwitchChange)
}

@Composable
fun ViewB(switchState: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Switch(
        checked = switchState,
        onCheckedChange = onSwitchChange
    )
}
