package com.example.practicingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicingcompose.ui.theme.PracticingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticingComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        //verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color.LightGray)
            .clip(RoundedCornerShape(24.dp))
            .fillMaxSize()
    ) {
        MainInfo(
            "Caie",
            "Hallite",
            "Android Developer",
            R.drawable.caie1
        )
        Spacer(modifier.padding(24.dp))
        InfoTwo(
            "caie@gmail.com",
            "(16)99994-1388",
            "Pedro de Souza C. Filho, 14"
        )
        Spacer(modifier.padding(24.dp))
        Buttons()
    }
}

@Composable
fun MainInfo(
    firstName: String,
    lastName: String,
    ocuppation: String,
    @DrawableRes picture: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(picture),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(240.dp)
                .padding(12.dp)
                .clip(CircleShape)
        )
        Text(
            text = "$firstName $lastName",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = ocuppation,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.buttonColor)
            )
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                "Edit"
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Edit Profile"
            )
        }
    }
}

@Composable
fun InfoTwo(
    email: String,
    phoneNumber: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row {
            Icon(
                imageVector = Icons.Default.Email,
                "E-mail",
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = email
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.Phone,
                "Phone",
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = phoneNumber
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                "Address",
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = address
            )
        }

    }
}

@Composable
fun Buttons(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(modifier) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = modifier.width(140.dp)
            ) {
                Text(
                    text = "Mensagens",
                    color = Color.Black
                )
            }
            Spacer(modifier.padding(2.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(4.dp),
                modifier = modifier.width(140.dp)
            ) {
                Text(
                    text = "Configurações",
                    color = Color.Black
                )
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "Sair",
                color = Color.Black
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    PracticingComposeTheme {
        HomeScreen()
    }
}
