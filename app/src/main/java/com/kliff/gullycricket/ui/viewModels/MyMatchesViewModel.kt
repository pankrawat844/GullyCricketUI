package com.kliff.gullycricket.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kliff.gullycricket.ui.models.MatchList
import com.kliff.gullycricket.data.repository.MyMatchRepository

class MyMatchesViewModel(application: Application) : AndroidViewModel(application) {

    private val myMatchRepository = MyMatchRepository(application)

    private val getAllMatches = myMatchRepository.getAllMatches()

    fun insert(matchList: MatchList) {
        myMatchRepository.insert(matchList)
    }

    fun getAllMatches(): LiveData<List<MatchList>> {
        return getAllMatches
    }
}