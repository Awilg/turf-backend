package dev.iwagl.territories.models

import kotlinx.serialization.Serializable

@Serializable
enum class Features {
    Normal,
    Park,
    Waterfront,
    Tourism,
    Athletics,
}