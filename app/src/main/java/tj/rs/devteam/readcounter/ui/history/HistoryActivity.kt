package tj.rs.devteam.readcounter.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import tj.rs.devteam.readcounter.R
import tj.rs.devteam.readcounter.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    var adapter = ReadHistoryRVAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityHistoryBinding>(this, R.layout.activity_history)

        val viewModel = ViewModelProvider(this).get(HistoryActivityViewModel::class.java)
        binding.viewModel = viewModel

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(DividerItemDecoration(this, 1))
        viewModel.repository.observe(this, Observer {
            adapter.replaceData(it)
        })
    }
}
