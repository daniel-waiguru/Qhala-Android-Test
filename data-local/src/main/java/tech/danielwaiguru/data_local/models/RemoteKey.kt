package tech.danielwaiguru.data_local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKey(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val movieId: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
