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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(
                    puppySelected = ::puppySelected
                )
            }
        }
    }

    private fun puppySelected(puppy: Puppy) {
        startPuppyDetailsActivity(puppy)
    }
}

// Start building your app here!
@Composable
fun MyApp(
    puppySelected: ((Puppy) -> Unit)? = null
) {
    val puppies = listOf(
        Puppy("Basenji", R.drawable.basenji, "The Basenji is a breed of hunting dog. It was bred from stock that originated in central Africa. Most of the major kennel clubs in the English-speaking world place the breed in the hound group, specifically in the sighthound type. The Fédération Cynologique Internationale places the breed in its group five, and the United Kennel Club places the breed in its Sighthound and pariah group."),
        Puppy("Canaan", R.drawable.canaan, "The Canaan Dog, also known as the Bedouin Sheepdog and Palestinian Pariah Dog,[2] is a breed of pariah dog originating from the Middle East. It can be found in Israel, Jordan, Lebanon, the Sinai peninsula, and these or dogs very similar are found in Egypt, Iraq, and Syria. It is the national dog of Israel. There are 2,000 to 3,000 Canaan dogs across the world, mostly in Europe and North America."),
        Puppy("Carolina", R.drawable.carolina, "The Carolina dog, also known as a yellow dog, yaller dog, American Dingo, or Dixie Dingo, is a breed of medium-sized dog occasionally found feral in Southeastern United States, especially in isolated stretches of longleaf pines and cypress swamps. Efforts to establish them as a standardized breed has gained the Carolina Dog breed recognition in two smaller kennel clubs and full acceptance into the breed-establishment program of one major kennel club. "),
        Puppy("Dingo", R.drawable.dingo, "The dingo (Canis familiaris, Canis familiaris dingo, Canis dingo, or Canis lupus dingo) is a dog found in Australia. Its taxonomic classification is debated. It is a medium-sized canine that possesses a lean, hardy body adapted for speed, agility, and stamina. The dingo's three main coat colourations are light ginger or tan, black and tan, or creamy white. The skull is wedge-shaped and appears large in proportion to the body."),
        Puppy("New Guinea singing dog", R.drawable.new_guinea_singing_dog, "The New Guinea singing dog or New Guinea Highland dog is a type of dog native to the New Guinea Highlands of the island of New Guinea. Once considered to be a separate species in its own right, under the name Canis hallstromi, it is closely related to the Australian dingo. The dog has a reputation for its unique vocalization. "),
        Puppy("Peruvian Hairless", R.drawable.peruvian_hairless, "The Peruvian Hairless Dog, Peruvian viringo, naked dog, or Chimú dog is one of several breeds of hairless dog. It is native to Peru and it is usually raised as a pet. It has been officially recognized as part of Peru's cultural heritage."),
        Puppy("Podenco Ibicenco", R.drawable.podenco_ibicenco, "The Ibizan Hound (Spanish: podenco ibicenco, Catalan: ca eivissenc) is a lean, agile dog of the hound family. There are two hair types of the breed: smooth and wire. The more commonly seen type is the smooth. Some consider there to be a third type, long, but the longhair is most likely a variation of the wire."),
        Puppy("xoloitzcuintle", R.drawable.xoloitzcuintle, "The Xoloitzcuintle/Xoloitzquintle/Xoloitzcuintli, or Xolo is one of several breeds of hairless dog. It is found in Estándar (Standard), Intermedio (intermediate), and Miniatura (miniature) sizes. The Xolo also comes in a coated variety totally covered of fur and coated and hairless can be born in the same litter as a result of the same combination of genes. The hairless variant known as the Perro pelón mexicano or Mexican hairless dog. It is characterized by its duality, wrinkles, and dental abnormalities, same as a primitive temper. In Nahuatl, from which its name originates, it's xōlōitzcuintli and xōlōitzcuintin. The name comes from the god Xolotl that according to ancient narratives it's his creator and itzcuīntli, meaning dog in Nahuatl language."),
    )

    Surface(color = MaterialTheme.colors.background) {
        PuppyList(
            puppies = puppies,
            puppySelected = puppySelected
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
