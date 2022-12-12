package com.example.project

import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class ToursReposotiry(private val dao: Dao) {

    val allTours = dao.getAllData()


        suspend fun insert(tour: Tours) {
            return dao.insert(tour)
        }

        suspend fun delete() {
            return dao.delete()
        }
        suspend fun takeData(id :Int): LiveData<List<Tours>> {
          return dao.specific_ID(id)
        }
        suspend fun update(basket:Int,id: Int){
            dao.update(basket,id)
        }

}
