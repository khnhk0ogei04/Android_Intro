package com.example.zodiac.data.model

data class Zodiac(
    val name: String,
    val drawableId: Int?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Zodiac
        return drawableId == other.drawableId
    }

    override fun hashCode(): Int {
        return drawableId ?: 0
    }
}