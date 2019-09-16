package com.kliff.gullycricket.data.room.myMatchesRoom

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kliff.gullycricket.ui.models.MatchList

@Database(entities = [MatchList::class], version = 2)
abstract class MyMatchesDataBase : RoomDatabase() {
    abstract fun myMatchesDao(): MyMatchesDAO

    companion object {
        private var instance: MyMatchesDataBase? = null

        fun getInstance(context: Context): MyMatchesDataBase? {
            if (instance == null)
                synchronized(MyMatchesDataBase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyMatchesDataBase::class.java,
                        "gullyCricket_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            return instance
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(instance).execute()
            }
        }
    }

    class PopulateAsyncTask(db: MyMatchesDataBase?) : AsyncTask<Unit, Unit, Unit>() {

        private val myMatchesDAO = db?.myMatchesDao()

        override fun doInBackground(vararg p0: Unit?) {
            myMatchesDAO?.insert(
                MatchList(
                    null, null, "India",
                    "West-Indies", "250-6", "230-10", "50 over", "50 over"
                )
            )

            myMatchesDAO?.insert(
                MatchList(
                    null, null, "India",
                    "West-Indies", "250-6", "230-10", "50 over", "50 over"
                )
            )

            myMatchesDAO?.insert(
                MatchList(
                    null, null, "India",
                    "West-Indies", "250-6", "230-10", "50 over", "50 over"
                )
            )
        }
    }
}