package dev.iwagl.territories.models

import kotlinx.serialization.Serializable

@Serializable
enum class Tier {
    Common,
    Uncommon,
    Rare,
    Epic,
    Legendary
}