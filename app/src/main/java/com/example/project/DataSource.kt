package com.example.project

class DataSource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.drawable.p1,"h"),
            Affirmation(R.drawable.p2,"d"),
            Affirmation(R.drawable.p3,"d"),
            Affirmation(R.drawable.p4,"f"),
            Affirmation(R.drawable.p5,"f"),

        )
    }


}

class Affirmation (val a:Int,val b:String){

}


