package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Column(Modifier.fillMaxWidth()) {
            puppies.forEach { puppy ->
                PuppyListItem(
                    puppy = puppy,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun PuppyListLightPreview() {
    val puppies = listOf(
        Puppy("Basenji", R.drawable.basenji),
        Puppy("Canaan", R.drawable.canaan),
        Puppy("Carolina", R.drawable.carolina),
        Puppy("Dingo", R.drawable.dingo),
        Puppy("New Guinea singing dog", R.drawable.new_guinea_singing_dog),
        Puppy("Peruvian Hairless", R.drawable.peruvian_hairless),
        Puppy("Podenco Ibicenco", R.drawable.podenco_ibicenco),
        Puppy("xoloitzcuintle", R.drawable.xoloitzcuintle),
    )

    MyTheme {
        PuppyList(puppies)
    }
}
