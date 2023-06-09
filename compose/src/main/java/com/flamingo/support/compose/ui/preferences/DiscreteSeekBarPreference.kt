/*
 * Copyright (C) 2022 FlamingoOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flamingo.support.compose.ui.preferences

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun DiscreteSeekBarPreference(
    title: String,
    modifier: Modifier = Modifier,
    summary: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    min: Int,
    max: Int,
    value: Int,
    showProgressText: Boolean = false,
    onProgressChanged: (Int) -> Unit,
    onProgressChangeFinished: () -> Unit = {},
) {
    Preference(
        modifier = modifier,
        title = title,
        summary = summary,
        enabled = enabled,
        onClick = {
            onClick()
        },
        bottomWidget = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Slider(
                    modifier = Modifier.weight(1f),
                    onValueChange = {
                        onProgressChanged(
                            if (it > value) {
                                floor(it).toInt()
                            } else {
                                ceil(it).toInt()
                            }
                        )
                    },
                    onValueChangeFinished = onProgressChangeFinished,
                    valueRange = min.toFloat()..max.toFloat(),
                    value = value.toFloat(),
                    enabled = enabled
                )
                if (showProgressText) {
                    Text(
                        modifier = Modifier.width(36.dp),
                        text = value.toString(),
                        color = MaterialTheme.colorScheme.onSurface,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        textAlign = TextAlign.End
                    )
                }
            }
        },
    )
}