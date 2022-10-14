package tech.danielwaiguru.data_local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.danielwaiguru.data_local.models.RemoteKey

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveKeys(remoteKeys: List<RemoteKey>)

    @Query("SELECT * FROM remote_keys WHERE movieId = :keyId")
    suspend fun getRemoteKeyById(keyId: Int): RemoteKey

    @Query("SELECT * FROM remote_keys ORDER BY id DESC LIMIT 1")
    suspend fun getLastRemoteKey(): RemoteKey?

    @Query("DELETE FROM remote_keys")
    suspend fun deleteAllKeys()
}