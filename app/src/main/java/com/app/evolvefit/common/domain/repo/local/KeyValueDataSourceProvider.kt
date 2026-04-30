package com.app.evolvefit.common.domain.repo.local

interface KeyValueDataSourceProvider {
    suspend fun <Value> save(key: KeyValueDataSourceKey, value: Value, type: Class<*>)
    suspend fun <Value> read(key: KeyValueDataSourceKey, defaultValue: Value, type: Class<*>): Value
    suspend fun <Value> delete(key: KeyValueDataSourceKey, type: Class<*>)
}