package tj.rs.devteam.readcounter.repository.room

import androidx.room.Dao
import androidx.room.Query
import tj.rs.devteam.readcounter.model.Read

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
@Dao
interface ReadDao {

    @Query("SELECT * FROM read ORDER BY date_time DESC")
    fun getAll(): List<Read>

    @Query("INSERT INTO read(date_time) VALUES(strftime('%s', CURRENT_TIMESTAMP))")
    fun addRead()

    @Query("select COUNT(date_time)from read where date_time BETWEEN (strftime('%s', CURRENT_DATE)) and (strftime('%s', CURRENT_DATE || ' 23:59:59'))")
    fun getTodayReadCount(): Int

    @Query("delete from read where id = (SELECT id FROM read ORDER BY id DESC LIMIT 1);")
    fun deleteLastRead()
}