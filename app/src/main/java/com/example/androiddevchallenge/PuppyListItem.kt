package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyListItem(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Surface(
            color = Color.White,
            shape = CircleShape,
            modifier = modifier
                .size(80.dp, 72.dp)
                .padding(end = 8.dp)
        ) {
            Image(
                painterResource(puppy.imageResourceId),
                "Picture of $puppy.name"
            )
        }
        Text(
            text = puppy.name,
            style = typography.body1,
            modifier = Modifier
                .height(80.dp)
                .wrapContentSize(Alignment.CenterStart)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun PuppyListItemLightPreview() {
    MyTheme {
        PuppyListItem(
            puppy = Puppy("Hans Landa", R.drawable.basenji)
        )
    }
}
