package dev.iwagl.game.api.response

import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(
    val gameId: String,
    val createdAt: String,
    val startsAt: String,
    val endsAt: String,
    val status: String)