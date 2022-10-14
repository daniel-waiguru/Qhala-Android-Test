package tech.danielwaiguru.data_local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val language: String,
    @ColumnInfo(name = "original_title")
    val overview: String,
    val popularity: Double,
    val poster: String,
    val title: String,
    val voteCount: Int,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    val date: String
)