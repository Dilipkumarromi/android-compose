package com.example.mycomposeapplications

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
                    ListViewsData()


                }
            }
        }
    }
}
@Preview
@Composable
fun CustomeList(){

}
@Preview
@Composable
 fun ListViewsData() {
     var context= LocalContext.current
    var personList = listOf(
        "Ruth",
        "Dilip",
        "Suresh",
        "Ramesh",
        "Dinesh",
        "Ganesh",
        "Radhika",
        "Raunak"
    )
    LazyColumn {
        //only print name of click event
//          items(
//              items=personList,
//              itemContent = {person ->
//                  androidx.compose.material3.Text(
//                  text = person,
//                  modifier = Modifier.padding(16.dp)
//                      .clickable {
//                          Toast.makeText(context,"$person",Toast.LENGTH_SHORT).show()
//                      }
//              )
//                  Divider()//---> vertical and horizontal line
//              }
//
//          )
        // name and index item position click
        itemsIndexed(personList){
            index, item ->
            androidx.compose.material3.Text(
                text = "$index. $item",
                modifier = Modifier.padding(16.dp)
                    .clickable {
                        Toast.makeText(context,"index:-${index}-$item",Toast.LENGTH_SHORT).show()
                    }
            )
            Divider()//---> vertical and horizontal line

        }

    }
}


@Preview
@Composable
 fun EditTextOrTextField() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(value = text, onValueChange = {
        text=it
    },
        textStyle = TextStyle(color=Color.Red),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            autoCorrect = true,
            keyboardType = KeyboardType.Text
        ),
        placeholder = {
            Text(text = "Enter the name")
        },
        singleLine = true
    )

}

@Preview
@Composable
fun ImagesStyles(){
    Image(painter = painterResource(id = R.drawable.profile_image),
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        modifier = Modifier.size(200.dp),
        contentDescription = "")
}

@Preview
@Composable
fun RoundedCornerImages() {
    Image(painter = painterResource(id = R.drawable.profile_image),
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(4.dp, Color.Red, RoundedCornerShape(4.dp)),
        contentDescription = "")
}

@Preview
@Composable
fun CircleImage() {
    Image(painter = painterResource(id = R.drawable.profile_image),
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .clip(CircleShape)
            .border(4.dp, Color.Yellow, RoundedCornerShape(4.dp)),
        contentDescription = "")
}

@Preview
@Composable
fun CustomCard() {
    Row() {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp),
            shape = CutCornerShape(
                topStartPercent = 50,
                topEndPercent = 25,
                bottomStartPercent = 50,
                bottomEndPercent = 50
            ),
            colors = CardDefaults.cardColors(Color(0xFFFA1745))
        )

        {
            Box() {
                Text(
                    text = "SALE", color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(35.dp)
                        .padding(top = 19.dp)
                        .align(Alignment.Center)
                        .rotate(-45f)
                )
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(5.dp)
                        .padding(top = 16.dp)
                        .size(16.dp),

                    shape = CircleShape
                ) {

                }
            }
        }

        Card(
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp),
            shape = CutCornerShape(
                topStartPercent = 50,
                topEndPercent = 50,
                bottomStartPercent = 50,
                bottomEndPercent = 50
            ),
            colors = CardDefaults.cardColors(Color(0xFFFA1745))
        )

        {
            Box() {
                Text(
                    text = "50%\nOFF", color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(30.dp)
                        .padding(5.dp)
                        .align(Alignment.Center)
                )
                Card(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(15.dp)
                        .padding(start = 10.dp)
                        .size(16.dp),

                    shape = CircleShape
                ) {

                }
            }
        }

    }
}

@Preview
@Composable
fun shapesDesign() {
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
            modifier = Modifier
                .size(100.dp)
                .padding(top = 10.dp),
        ) {

        }

        Card(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            modifier = Modifier
                .size(100.dp)
                .padding(top = 10.dp),
        ) {

        }
        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(100.dp)
                .padding(top = 10.dp),
        ) {

        }

        Card(
            shape = AbsoluteCutCornerShape(16.dp),
            modifier = Modifier
                .size(100.dp)
                .padding(top = 10.dp),
        ) {

        }
    }
}

@Composable
fun buttonClick() {
    var count by remember {
        mutableIntStateOf((0))
    }
    var conText = LocalContext.current
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

            myToast(conText, message = "Click button actions")// pass msg context toast
            count++
        }, shape = RoundedCornerShape(8.dp),
            content = {
                androidx.compose.material3.Text(
                    text = "Click me"
                )
            })
    }

}

@Composable
fun outlineButton() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, Color.Black),
        shape = CircleShape,
        modifier = Modifier
            .size(200.dp)

    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "")
    }
}

@Composable
fun outlineButtonWithText() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        enabled = true,
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        androidx.compose.material3.Text(text = "Click me")
    }
}

fun myToast(context: Context, message: String) {
    println("Click-->$message")
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun TextAreaView() {
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
        Text(
            text = "Age:30",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(16.dp)
        )
        SimpleClickableText()
        marginPadding()
        Row() {
            Text(
                text = "Gender:Male",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(16.dp)
            )
            Text(text = "Gender:Female", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }

    }


}

@Composable
fun SimpleClickableText() {
    ClickableText(
        text = AnnotatedString("Hi Baby"),
        onClick = {
            Log.d("click-me", "Amngo")
        },
        style = TextStyle(
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
    )
}

@Composable
fun marginPadding() {
    Text(
        text = "All side padding",
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