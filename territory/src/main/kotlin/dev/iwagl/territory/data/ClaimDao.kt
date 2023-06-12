package dev.iwagl.territory.data

import com.mongodb.client.MongoCollection
import dev.iwagl.territories.models.Claim

class ClaimDao(private val collection: MongoCollection<Claim>) : BaseDao<Claim>(collection)