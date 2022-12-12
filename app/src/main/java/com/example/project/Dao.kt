package com.example.project
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insert(tour:Tours)
    @Query("SELECT * FROM tours")
    fun getAllData(): Flow<List<Tours>>
    @Query("SELECT * FROM tours WHERE basket = 1")
    fun basketlist():Flow<List<Tours>>
    @Query("UPDATE tours SET basket=:basket WHERE id = :id")
    fun update(basket: Int,id:Int)
    @Query("DELETE FROM tours WHERE id=10")
    fun delete()
    @Query("SELECT * FROM tours WHERE id = :pos_id")
    fun specific_ID(pos_id : Int): LiveData<List<Tours>>
    @Query("UPDATE tours SET rating=:rating WHERE id =:id")
    fun updateR(rating:String,id:Int)
    @Query("SELECT * FROM tours WHERE name LIKE :searchQuery ")
    fun searchDatabase(searchQuery: String): Flow<List<Tours>>
    @Query("SELECT * FROM tours WHERE rating LIKE '4%'OR rating LIKE '5%' LIMIT 5" )
    fun getSortedData(): Flow<List<Tours>>

}