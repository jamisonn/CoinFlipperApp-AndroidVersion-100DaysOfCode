package com.example.coinflipperprogram

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.coinflipperprogram.ui.theme.CoinFlipperProgramTheme
import kotlin.random.Random

class ResultScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coinAmount = intent?.getIntExtra("coins", 0) ?: 0
        Log.d("numAmount", "Amount: $coinAmount")
        setContent {
            CoinFlipperProgramTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Flipped: $coinAmount")
                    Coinflip(coins = coinAmount)
                }
            }
        }
    }

@Composable
 fun Coinflip(coins: Int){
        var headCount:Int = 0
        var tailsCount:Int = 0

        repeat(coins){
            val randomizer:Int = Random.nextInt(2)
            if (randomizer == 0) headCount++ else tailsCount++
        }
    Text(text = "Heads: $headCount")
    Text(text = "Tails: $tailsCount")

}
}