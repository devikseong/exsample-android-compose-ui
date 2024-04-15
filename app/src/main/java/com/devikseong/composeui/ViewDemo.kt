package com.devikseong.composeui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DemoView() {
    var value by remember{ mutableStateOf("HAHA1") }

    val closure = { data: String ->
        value = data
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Print Data $value")
        Spacer(modifier = Modifier.height(100.dp))
        Text("Print Data End")

        println("TEST 0 >>")

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            val checked = remember{ mutableStateOf(false) }

            Switch(
                checked = checked.value,
                onCheckedChange = { checked.value = it }
            )

            println("TEST 1 >>")

            if(checked.value) {
                Text("Switch is On")
            } else {
                Text("Switch is Off")
            }
        }
    }

}
