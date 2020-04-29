package tj.rs.devteam.readcounter.repository

import tj.rs.devteam.readcounter.model.Read
import tj.rs.devteam.readcounter.repository.room.ReadDao

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
class DbRepository(val dao: ReadDao) {

    fun addRead() {
        dao.addRead()
    }

    fun getTodayReadCount(): Int {
        return dao.getTodayReadCount()
    }

    fun deleteLastRead() {
        dao.deleteLastRead()
    }

    fun getAll(onHistoryDataReadyCallback: OnHistoryDataReadyCallback) {
        val d = dao.getAll()

        onHistoryDataReadyCallback.onDataReady(d)
    }

    interface OnHistoryDataReadyCallback {
        fun onDataReady(data: List<Read>)
    }
}
