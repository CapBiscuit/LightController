package com.example.lightcontroller


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lightcontroller.ui.theme.LightControllerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LightControllerTheme {

                LightController()

            }
        }
    }
}

@Composable
fun LightController() {
    var lightStatus by remember {
        mutableStateOf(true)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    if (lightStatus) Color(255, 245, 210, 255)
                    else Color(220, 220, 220, 255),
                        shape = RoundedCornerShape(24.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(48.dp)
        )
        {
            Column(
                modifier = Modifier.padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(
                            if (lightStatus) Color(255, 200, 100)
                            else Color(128, 128, 128, 255),
                            shape = RoundedCornerShape(100.dp)
                        )
                )
                Box(
                    modifier = Modifier
                        .size(width = 30.dp, height = 40.dp)
                        .background(
                            Color(0, 0, 0),
                            shape = RectangleShape
                        )
                )
            }

            Column(
                modifier = Modifier.padding(bottom = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            )
            {
                Text(
                    text = "Освещение",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (lightStatus) Color(217, 245, 220)
                                    else Color(246, 213, 211, 255)
                        )
                        .padding(28.dp, 8.dp)
                )
                {
                    Text(
                        text = if (lightStatus) "Включено" else "Выключено",
                        fontSize = 24.sp,
                        color = if (lightStatus) Color(25, 80, 60)
                                else Color(126, 33, 26, ),
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        )
        {
            Button(
                onClick = {
                    lightStatus = true
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (lightStatus) Color(40, 130, 255)
                                     else Color(226, 236, 246, 255))

            )
            {
                Text(
                    text = "Выключить",
                    fontSize = 28.sp,
                    color = if (lightStatus) Color.White else Color.Black,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Button(
                onClick = {
                    lightStatus = false
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!lightStatus) Color(40, 130, 255)
                                     else Color(226, 236, 246, 255))
            )
            {
                Text(
                    text = "Включить",
                    fontSize = 28.sp,
                    color = if (!lightStatus) Color.White else Color.Black,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}