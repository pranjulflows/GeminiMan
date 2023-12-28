@file:OptIn(ExperimentalMaterial3Api::class)

package com.macamps.geminiman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.macamps.geminiman.ui.theme.GeminiManTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeminiManTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GeminiApp()
                }
            }
        }
    }
}


@Composable
fun GeminiApp() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)) { innerPadding ->
        GeminiChat(innerPadding)
    }

}

@Composable
fun GeminiChat(padding: PaddingValues) {
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    Column(
        modifier = Modifier
    ) {
        LazyColumn() {
            items(count = 100) {

                val color =
                    Color(
                        Random.nextInt(256),
                        Random.nextInt(256),
                        Random.nextInt(256),
                    )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color = color)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Yellow)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.DarkGray)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Blue)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Magenta)
        )

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeminiManTheme {
        Greeting("Android")
    }
}