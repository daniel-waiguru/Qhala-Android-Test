package tech.danielwaiguru.data_local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    val adult: Boolean,
    @PrimaryKey
    val id: Int,
    val language: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val poster: String,
    val title: String,
    val voteCount: Int
)