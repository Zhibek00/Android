package com.example.project

class DataSource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(1,"h"),
            Affirmation(2,"d"),
            Affirmation(2,"d"),
            Affirmation(10,"f"),

        )
    }


}

class Affirmation (val a:Int,val b:String){

}


