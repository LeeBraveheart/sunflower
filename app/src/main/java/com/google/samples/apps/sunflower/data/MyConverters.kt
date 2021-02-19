/*
 * Copyright 2021 Google LLC
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

package com.google.samples.apps.sunflower.data

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

/**
@author JesseLee
@date : 2021/2/19 10:56
 */
class MyConverters {
    @TypeConverter fun longToMyDate(value:Long):MyDate= MyDate(value)
    @TypeConverter fun myDateToLong(value:MyDate):Long= value.toLong()
}

class MyDate(private val value: Long) {
    fun time():String= dateFormat.format(Date(value))
    fun toLong(): Long=Date(value).time

    companion object {
        private val dateFormat = SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINESE)
    }
}
