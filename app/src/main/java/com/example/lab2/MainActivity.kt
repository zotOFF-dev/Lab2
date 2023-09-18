package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(s: String) {
    val text = remember {
        mutableStateOf("")
    }
    val numA = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = text.value, Modifier.fillMaxWidth(1f))
        TextField(value = numA.value, onValueChange = {
            numA.value = it
            if (numA.value.filter { it.isDigit() } != "") {
                val num = numA.value.filter { it.isDigit() }.toInt()
                var a = 0.0
                if (num < 7) {
                    for (i in 1..num) {
                        a += 1.0 / i
                        text.value = a.toString()
                    }
                } else text.value = "Результат не может быть получен"
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Greeting("Android")
    }
}