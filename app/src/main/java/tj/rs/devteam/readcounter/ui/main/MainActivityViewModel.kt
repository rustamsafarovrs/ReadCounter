package tj.rs.devteam.readcounter.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tj.rs.devteam.readcounter.repository.DbRepository
import tj.rs.devteam.readcounter.repository.room.AppDatabase

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val dao = Room.databaseBuilder(
        application, AppDatabase::class.java,
        "appDatabase"
    ).allowMainThreadQueries()
        .build()
        .readDao()

    val repository = DbRepository(dao)

    val readCount = MutableLiveData<Int>()

    init {
        readCount.postValue(repository.getTodayReadCount())
    }

    fun increment() {
        repository.addRead()
        readCount.postValue(repository.getTodayReadCount())
    }

    fun decrement() {
        if (readCount.value!! > 0) {
            repository.deleteLastRead()
            readCount.postValue(repository.getTodayReadCount())
        }
    }

}