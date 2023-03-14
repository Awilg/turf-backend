package main.kotlin.dev.iwagl.importer

interface IBaseDaoAsync<T : Any> {
    suspend fun load(id: String) : T?
    suspend fun save(obj : T) : Any?
    suspend fun delete(id: String) : Boolean
}