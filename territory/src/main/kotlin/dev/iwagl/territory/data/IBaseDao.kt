package dev.iwagl.common.data

import org.bson.types.ObjectId

interface IBaseDao<T : Any> {
    fun load(id: String) : T?
    fun load(id: ObjectId) : T?
    fun save(obj : T) : Boolean
    fun delete(id: String) : Boolean
}