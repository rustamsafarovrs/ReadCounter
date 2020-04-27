package tj.rs.devteam.readcounter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
@Entity
data class Read(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "date_time") val dateTime: Int
) {

    fun dateTimeToHumanReadable(): String {
        val unixSeconds = dateTime
        // convert seconds to milliseconds
        val date = Date(unixSeconds * 1000L)
        // the format of your date
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        return sdf.format(date)
    }

}