package com.app.evolvefit.common.data.repo.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.app.evolvefit.common.data.model.EvolveFitException
import com.app.evolvefit.common.domain.repo.local.KeyValueDataSourceKey
import com.app.evolvefit.common.domain.repo.local.KeyValueDataSourceProvider
import kotlinx.coroutines.flow.first

class KeyValueDataSourceProvider (private val dataStore: DataStore<Preferences>) : KeyValueDataSourceProvider {
    private fun <Value> preferencesKey(
        key: KeyValueDataSourceKey,
        type: Class<*>
    ): Preferences.Key<Value> {
        return when (type) {
            Boolean::class.java -> booleanPreferencesKey(key.keyValue)
            Float::class.java -> floatPreferencesKey(key.keyValue)
            Int::class.java -> intPreferencesKey(key.keyValue)
            Long::class.java -> longPreferencesKey(key.keyValue)
            String::class.java -> stringPreferencesKey(key.keyValue)
            Set::class.java -> stringSetPreferencesKey(key.keyValue)
            else -> throw EvolveFitException.Local.IOOperation()
        } as Preferences.Key<Value>
    }

    override suspend fun <Value> save(key: KeyValueDataSourceKey, value: Value, type: Class<*>) {
        val preferencesKey = preferencesKey<Value>(key, type)
        dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun <Value> read(
        key: KeyValueDataSourceKey,
        defaultValue: Value,
        type: Class<*>
    ): Value {
        val preferencesKey = preferencesKey<Value>(key, type)
        val preferences = dataStore.data.first()
        return preferences[preferencesKey] ?: defaultValue
    }

    override suspend fun <Value> delete(key: KeyValueDataSourceKey, type: Class<*>) {
        val preferencesKey = preferencesKey<Value>(key, type)
        dataStore.edit { preferences ->
            preferences.remove(preferencesKey)
        }
    }
}