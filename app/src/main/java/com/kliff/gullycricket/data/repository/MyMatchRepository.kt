package com.kliff.gullycricket.data.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.kliff.gullycricket.ui.models.MatchList
import com.kliff.gullycricket.data.room.myMatchesRoom.MyMatchesDAO
import com.kliff.gullycricket.data.room.myMatchesRoom.MyMatchesDataBase

class MyMatchRepository(application: Application) {

    private var myMatchesDAO: MyMatchesDAO
    private var allMyMatches: LiveData<List<MatchList>>

    init {
        val myMatchesDataBase = MyMatchesDataBase.getInstance(application.applicationContext)!!

        myMatchesDAO = myMatchesDataBase.myMatchesDao()
        allMyMatches = myMatchesDAO.getAllMatchList()
    }

    fun insert(matchList: MatchList) {
        InsertMatchAsyncTask(myMatchesDAO)
            .execute(matchList)
    }

    fun getAllMatches(): LiveData<List<MatchList>> {
        return allMyMatches
    }

    class InsertMatchAsyncTask(private val myMatchesDAO: MyMatchesDAO) : AsyncTask<MatchList, Unit, Unit>() {

        override fun doInBackground(vararg p0: MatchList?) {
            myMatchesDAO.insert(p0[0]!!)
        }
    }
}