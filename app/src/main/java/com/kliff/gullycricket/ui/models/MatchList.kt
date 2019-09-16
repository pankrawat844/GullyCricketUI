package com.kliff.gullycricket.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "my_matches_table")
data class MatchList constructor(

    var team1Image: String?,
    var team2Image: String?,
    var team1Name: String?,
    var team2Name: String?,
    var inningOne: String?,
    var inningTwo: String?,
    var inningThree: String,
    var inningFour: String
) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}