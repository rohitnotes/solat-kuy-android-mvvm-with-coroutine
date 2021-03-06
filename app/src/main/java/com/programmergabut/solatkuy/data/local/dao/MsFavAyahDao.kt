package com.programmergabut.solatkuy.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.programmergabut.solatkuy.data.local.localentity.MsFavAyah

@Dao
interface MsFavAyahDao {

    @Query("select * from MsFavAyah")
    fun observeListFavAyah(): LiveData<List<MsFavAyah>>

    @Query("select * from MsFavAyah where surahID like :surahID")
    suspend fun getListFavAyahBySurahID(surahID: Int): List<MsFavAyah>?

    @Query("delete from MsFavAyah")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteMsFavAyah(msFavAyah: MsFavAyah)

    @Query("delete from MsFavAyah where ayahID like :ayahID and surahID like :surahID")
    suspend fun deleteMsFavAyahByID(ayahID: Int, surahID: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMsAyah(msFavAyah: MsFavAyah)

}