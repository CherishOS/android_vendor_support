/*
 * Copyright (C) 2017 AICP
 *               2021 AOSP-Krypton Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.krypton.settings.preference

import android.content.Context
import android.util.AttributeSet

import androidx.core.content.res.TypedArrayUtils
import androidx.preference.PreferenceDataStore
import androidx.preference.R
import androidx.preference.SwitchPreference

abstract class SettingSwitchPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = TypedArrayUtils.getAttr(context,
        R.attr.switchPreferenceStyle,
        android.R.attr.switchPreferenceStyle),
    defStyleRes: Int = 0,
): SwitchPreference(context, attrs, defStyleAttr, defStyleRes) {

    init {
        setPreferenceDataStore(getSettingsDataStore(context))
    }

    abstract fun getSettingsDataStore(context: Context): PreferenceDataStore
}