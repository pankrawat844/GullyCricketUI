package com.kliff.gullycricket.data.room.myMatchesRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kliff.gullycricket.ui.models.MatchList

@Dao
interface MyMatchesDAO {

    @Insert
    fun insert(matchList: MatchList)

    @Query("SELECT * FROM my_matches_table")
    fun getAllMatchList() : LiveData<List<MatchList>>
}