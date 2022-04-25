package com.example.inventory.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao //DataAcessObjects
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): kotlinx.coroutines.flow.Flow<List<Item>> // StateFlow requires an initial state to be passed into the constructor, while LiveData does not.

}

