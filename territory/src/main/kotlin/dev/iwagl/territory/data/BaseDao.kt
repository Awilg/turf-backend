package dev.iwagl.territory.data

import com.mongodb.client.MongoCollection
import dev.iwagl.common.data.IBaseDao
import org.bson.types.ObjectId
import org.litote.kmongo.deleteOneById
import org.litote.kmongo.findOneById
import org.litote.kmongo.toId

open class BaseDao<T : Any>(private val collection: MongoCollection<T>) :
    IBaseDao<T> {

    override fun load(id: String): T? {
        return collection.findOneById(id.toId<T>())
    }

    override fun load(id: ObjectId): T? {
        return collection.findOneById(id)
    }

    override fun save(obj: T): Boolean {
        return collection.insertOne(obj).wasAcknowledged()
    }

    override fun delete(id: String): Boolean {
        return collection.deleteOneById(id.toId<T>()).wasAcknowledged()
    }
}