package com.example.project

import android.app.Application
import android.text.Editable
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToursViewModel (application: Application): AndroidViewModel(application) {
   // val allTours: LiveData<List<Tours>> = repository.allTours.asLiveData()
   private var repository: ToursReposotiry
   lateinit var basketNum:String
    val readAllData: LiveData<List<Tours>>
   var readData: LiveData<List<Tours>>
    var topData: LiveData<List<Tours>>
    lateinit var basketData: LiveData<List<Tours>>
   var userDao : Dao


    init {
         userDao = MainDb.getDb(application).getDao()
        repository = ToursReposotiry(userDao)
        readAllData = repository.allTours.asLiveData()
        readData = readAllData
        topData = userDao.getSortedData().asLiveData()
        basketData=userDao.basketlist().asLiveData()
        if(basketData.value==null){
            basketNum="Empty list"
        }
        else{
            basketNum="Basket"
        }
    }
      fun takeDate(id: Int){
          viewModelScope.launch(Dispatchers.IO) {
            readData =   repository.takeData(id)
          }

      }


    fun updateData(basket:Int,id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.update(basket,id)
            if(basketData.value==null){
                basketNum="Empty list"
            }
            else{
                basketNum="Basket"
            }
        }
    }
    fun updateRating(rating: String,id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.updateR(rating,id)

        }
    }
    fun sort(){
        topData =  userDao.getSortedData().asLiveData()
    }
    fun searchDatabase(searchQuery: String): LiveData<List<Tours>> {

            return userDao.searchDatabase(searchQuery).asLiveData()

    }


}

