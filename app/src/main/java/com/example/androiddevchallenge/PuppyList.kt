/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    modifier: Modifier = Modifier,
    puppySelected: ((Puppy) -> Unit)? = null,
) {
    Box(modifier) {
        Column(Modifier.fillMaxWidth()) {
            puppies.forEach { puppy ->
                PuppyListItem(
                    puppy = puppy,
                    puppySelected = puppySelected,
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
        Puppy("Basenji", R.drawable.basenji, ""),
        Puppy("Canaan", R.drawable.canaan, ""),
        Puppy("Carolina", R.drawable.carolina, ""),
        Puppy("Dingo", R.drawable.dingo, ""),
        Puppy("New Guinea singing dog", R.drawable.new_guinea_singing_dog, ""),
        Puppy("Peruvian Hairless", R.drawable.peruvian_hairless, ""),
        Puppy("Podenco Ibicenco", R.drawable.podenco_ibicenco, ""),
        Puppy("xoloitzcuintle", R.drawable.xoloitzcuintle, ""),
    )

    MyTheme {
        PuppyList(puppies)
    }
}
