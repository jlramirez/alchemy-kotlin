/*
 * Copyright 2017 SirWellington Tech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.sirwellington.alchemy.kotlin.extensions


/**
 *
 * @author SirWellington
 */

/**
 * Removes all of the entries from this Map that match the given predicate.
 *
 * @return The number of entries removed
 */
inline fun <reified K, reified V> MutableMap<K, V>.removeWhere(predicate: (Map.Entry<K, V>) -> Boolean): Int
{
    val keysToRemove = entries.filter(predicate).map { it.key }

    keysToRemove.forEach {
        this.remove(it)
    }

    return keysToRemove.size
}

/**
 * @author Joel Ramirez
 *
 * @return a random entry from map
 */
val <K,V> Map<K, V>.anyEntry: Map.Entry<K, V>?
    get()
    {
        val entryList = entries.toList()
        return entryList.anyElement
    }

