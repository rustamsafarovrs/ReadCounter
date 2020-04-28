package tj.rs.devteam.readcounter.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tj.rs.devteam.readcounter.model.Read
import tj.rs.devteam.readcounter.repository.room.AppDatabase

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
class HistoryActivityViewModel(application: Application) : AndroidViewModel(application) {
    val dao = AppDatabase.getInstance(application).readDao()

    val repository = MutableLiveData<List<Read>>()

    init {
        repository.postValue(dao.getAll())
    }
}