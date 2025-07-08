package com.example.demeterinmultimoduleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.demeterinmultimoduleapp.ui.theme.DemeterInMultiModuleAppTheme
import com.example.mylibrary.compose.DemeterDoesNotWork
import com.yandex.demeter.Demeter
import com.yandex.demeter.DemeterInitializer
import com.yandex.demeter.profiler.compose.ComposeDemeterPlugin
import com.yandex.demeter.profiler.tracer.TracerDemeterPlugin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Demeter.init(
            DemeterInitializer(
                context = this,
                plugins = listOf(
                    TracerDemeterPlugin(),  // turn on Tracer plugin
                    ComposeDemeterPlugin(), // turn on Compose plugin
                ),
            )
        )
        enableEdgeToEdge()
        setContent {
            DemeterInMultiModuleAppTheme {
                DemeterDoesNotWork()  // Demeter doesnt work
//                DemeterIsWork() // Demeter is work
            }
        }
    }
}

@Composable
fun DemeterIsWork(){
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { count++ }) { Text("+") }

        Text(
            "$count",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        Button(onClick = { count-- }) { Text("-") }
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
    DemeterInMultiModuleAppTheme {
        Greeting("Android")
    }
}