package tj.rs.devteam.readcounter.repository.room

import androidx.room.Database
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
}