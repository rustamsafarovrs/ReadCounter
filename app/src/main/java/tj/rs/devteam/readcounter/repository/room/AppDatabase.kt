package tj.rs.devteam.readcounter.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tj.rs.devteam.readcounter.model.Read

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
@Database(entities = arrayOf(Read::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun readDao(): ReadDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = createInstance(context)
            }
            return instance!!
        }

        private fun createInstance(context: Context): AppDatabase =
            Room
                .databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "appDatabase"
                )
                .allowMainThreadQueries()
                .build()

    }
}