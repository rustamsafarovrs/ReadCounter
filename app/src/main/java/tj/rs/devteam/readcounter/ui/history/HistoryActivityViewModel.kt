package tj.rs.devteam.readcounter.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import tj.rs.devteam.readcounter.model.Read
import tj.rs.devteam.readcounter.repository.DbRepository
import tj.rs.devteam.readcounter.repository.room.AppDatabase

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */
class HistoryActivityViewModel(application: Application) : AndroidViewModel(application) {
    val dao = AppDatabase.getInstance(application).readDao()
    val dbRepository = DbRepository(dao)

    val isLoading = MutableLiveData<Boolean>()
    val repository = MutableLiveData<List<Read>>()

    init {
        loadData()
    }

    private fun loadData() {
        isLoading.postValue(true)
        dbRepository.getAll(object : DbRepository.OnHistoryDataReadyCallback {
            override fun onDataReady(data: List<Read>) {
                repository.postValue(data)
                isLoading.postValue(false)
            }
        })
    }
}