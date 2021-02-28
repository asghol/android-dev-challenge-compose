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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.androiddevchallenge.PuppyDetailsActivity.Companion.PUPPY_BREED_INFORMATION_EXTRA
import com.example.androiddevchallenge.PuppyDetailsActivity.Companion.PUPPY_DRAWABLE_ID_EXTRA
import com.example.androiddevchallenge.PuppyDetailsActivity.Companion.PUPPY_NAME_EXTRA
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class PuppyDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val puppy = getPuppyFromIntent()

        setContent {
            MyTheme {
                PuppyDetails(puppy)
            }
        }
    }

    private fun getPuppyFromIntent(): Puppy {
        val name = intent.extras?.get(PUPPY_NAME_EXTRA) as String
        val resourceId = intent.extras?.get(PUPPY_DRAWABLE_ID_EXTRA) as Int
        val breedDetails = intent.extras?.get(PUPPY_BREED_INFORMATION_EXTRA) as String

        return Puppy(name, resourceId, breedDetails)
    }

    companion object {
        const val PUPPY_NAME_EXTRA = "puppy_name_extra"
        const val PUPPY_DRAWABLE_ID_EXTRA = "puppy_drawable_id_extra"
        const val PUPPY_BREED_INFORMATION_EXTRA = "puppy_breed_information_extra"
    }
}

fun Context.startPuppyDetailsActivity(puppy: Puppy) {
    val intent = Intent(this, PuppyDetailsActivity::class.java).apply {
        putExtra(PUPPY_NAME_EXTRA, puppy.name)
        putExtra(PUPPY_DRAWABLE_ID_EXTRA, puppy.imageResourceId)
        putExtra(PUPPY_BREED_INFORMATION_EXTRA, puppy.breedDetails)
    }

    startActivity(intent)
}

@Composable
fun PuppyDetails(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
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

        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = puppy.breedDetails,
                style = typography.body2,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640, showBackground = true)
@Composable
fun PuppyDetailsLightPreview() {
    val puppy = Puppy("Basenji", R.drawable.basenji, "The Basenji is a breed of hunting dog. It was bred from stock that originated in central Africa. Most of the major kennel clubs in the English-speaking world place the breed in the hound group, specifically in the sighthound type. The Fédération Cynologique Internationale places the breed in its group five, and the United Kennel Club places the breed in its Sighthound and pariah group.")

    MyTheme {
        PuppyDetails(puppy)
    }
}
