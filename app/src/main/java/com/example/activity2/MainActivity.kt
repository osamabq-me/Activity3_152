package com.example.activity2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activity2.ui.theme.Activity2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    TampilanLayar(
                        pesan = getString(R.string.greeting),
                        dari = getString(R.string.name))
                }
            }
        }
    }
}


@Composable
fun TampilanText(message: String, from : String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ){
        Text(
            text = message,
            color = Color.Black,
            fontSize = 80.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            color = Color.White,
            fontSize = 40.sp,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun TampilanLayar(pesan: String, dari: String) {
    val image = painterResource(R.drawable.img)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        TampilanText(
            message = pesan,
            from = dari,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Activity2Theme {
        TampilanLayar("Hello", dari = "OSAMAH ALMEKHLAFI")
    }
}
