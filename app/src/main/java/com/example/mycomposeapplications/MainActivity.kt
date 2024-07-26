package com.example.mycomposeapplications

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.provider.CalendarContract.Colors
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapplications.ui.theme.MyComposeApplicationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    buttonClick()
                    Column(modifier = Modifier
                        .padding(all = 16.dp)
                        .padding(start = 26.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                        outlineButton()

                        outlineButtonWithText()
                    }

                }
            }
        }
    }
}
@Preview
@Composable
fun shapesDesign(){
    Column(
        modifier = Modifier.padding(16.dp)// for all side space
    ) {
        Card(
            shape = RectangleShape,
            modifier = Modifier.size(100.dp),
            border = BorderStroke(2.dp, color = Color.Red),

            ) {

        }

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.size(100.dp).padding(top = 10.dp),
        ) {

        }

        Card(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            modifier = Modifier.size(100.dp).padding(top = 10.dp),
        ) {

        }
        Card(
            shape = CircleShape,
            modifier = Modifier.size(100.dp).padding(top = 10.dp),
        ) {

        }

        Card(
            shape = AbsoluteCutCornerShape(16.dp),
            modifier = Modifier.size(100.dp).padding(top = 10.dp),
        ) {

        }
    }
}
@Composable
fun buttonClick(){
    var count by remember {
        mutableIntStateOf((0))
    }
    var conText= LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Text(
            text = "Total Click-$count",
            style = TextStyle(fontSize = 24.sp)
        )
        Button(onClick = {

            myToast(conText , message = "Click button actions")// pass msg context toast
            count++
                         }, shape = RoundedCornerShape(8.dp),
            content = { androidx.compose.material3.Text(
            text = "Click me"
        )})
    }

}

@Composable
fun outlineButton(){
    OutlinedButton(onClick = { /*TODO*/ },
        border= BorderStroke(2.dp, Color.Black),
        shape = CircleShape,
        modifier = Modifier
            .size(200.dp)

    ) {
        Icon(imageVector =Icons.Default.Add , contentDescription = "")
    }
}

@Composable
fun outlineButtonWithText(){
    OutlinedButton(onClick = { /*TODO*/ },
        enabled = true,
        border = BorderStroke(1.dp,Color.Blue)
    ) {
        androidx.compose.material3.Text(text = "Click me")
    }
}
fun myToast(context: Context,message: String){
    println("Click-->$message")
   Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}
@Composable
fun TextAreaView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                Color.Yellow,
                RoundedCornerShape(6.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Name:XYZ", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        Text(text = "Age:30",fontSize = 16.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic , modifier = Modifier.padding(16.dp))
        SimpleClickableText()
        marginPadding()
        Row (){
            Text(text = "Gender:Male",fontSize = 16.sp, textDecoration = TextDecoration.Underline , modifier = Modifier.padding(16.dp))
            Text(text = "Gender:Female",fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

    }


}

@Composable
fun SimpleClickableText(){
    ClickableText(
        text = AnnotatedString("Hi Baby") ,
        onClick = {
             Log.d("click-me","Amngo")
        },
    style = TextStyle(
        color = Color.Red,
        fontSize = 30.sp,
        fontFamily = FontFamily.Cursive
    )
    )
}
@Composable
fun marginPadding(){
    Text(text = "All side padding",
        // note first padding only padding and second padding for margin
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.White)
            .padding(all = 20.dp)
        )

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
    MyComposeApplicationsTheme {
        Greeting("Android")
    }
}