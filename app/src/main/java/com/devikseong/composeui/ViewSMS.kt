package com.devikseong.composeui

import android.telephony.SmsManager
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


//@Preview(showSystemUi = true)
@Composable
fun SmsScreen() {
    val context = LocalContext.current
    var phoneNumbers by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = phoneNumbers,
            onValueChange = { phoneNumbers = it },
            label = { Text("전화번호 (콤마로 구분)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("메시지 내용") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val phoneNumberList = phoneNumbers.split(",").map { it.trim() }
                val smsManager = SmsManager.getDefault()
                for (number in phoneNumberList) {
                    smsManager.sendTextMessage(number, null, message, null, null)
                }

//                val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01099039815;01021089815"))
//                smsIntent.putExtra("sms_body", "sms message goes here")
//                startActivity(context, smsIntent, null)

                Toast.makeText(context, "문자가 전송되었습니다.", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("전송")
        }
    }
}