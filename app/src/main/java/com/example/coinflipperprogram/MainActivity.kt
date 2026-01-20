package com.example.coinflipperprogram

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.coinflipperprogram.ui.theme.CoinFlipperProgramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinFlipperProgramTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Greeting(name = "Welcome to CoinFlipper Program")
                    val textState = remember { mutableStateOf("") }

                    TextField(
                        value = textState.value,
                        placeholder = { Text("How many coins?") },
                        onValueChange = { textState.value = it }
                    )

                    Button(onClick = {
                        val coins = textState.value.toIntOrNull() ?: 0
                        val intent = Intent(this@MainActivity, ResultScreen::class.java)
                        intent.putExtra("coins", coins)
                        startActivity(intent)}){
                        Text("Flip Coin")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(name)
}