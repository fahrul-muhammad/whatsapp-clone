package com.android.whatsappclone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.whatsappclone.R

@Composable
@Preview(showSystemUi = true)
fun Chat(modifier: Modifier = Modifier, name:String = "name", lastMessage:String = "last message", onClick:()->Unit = {}, time:String = "19.00", image: Painter = painterResource(R.drawable.user)) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .background(Color.Black)
            .height(70.dp)
            .clickable(
                onClick = onClick
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(55.dp))
                    .background(Color.Blue)
                    .height(55.dp)
                    .width(55.dp)
            ){
                Image(painter = image, contentDescription = null, modifier = modifier.fillMaxSize())
            }
            Spacer(modifier = modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxHeight()
            ) {
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.W700, color = Color.White)
                Text(text = lastMessage, fontSize = 15.sp, fontWeight = FontWeight.W600, color = colorResource(R.color.grey_msg))
            }
        }
        Text(text = time, fontSize = 15.sp, fontWeight = FontWeight.W600, color = colorResource(R.color.grey_msg))
    }
}