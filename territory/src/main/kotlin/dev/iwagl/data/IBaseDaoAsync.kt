package dev.iwagl.common.data

interface IBaseDaoAsync<T : Any> {
    suspend fun load(id: String) : T?
    suspend fun save(obj : T) : Any?
    suspend fun delete(id: String) : Boolean
}