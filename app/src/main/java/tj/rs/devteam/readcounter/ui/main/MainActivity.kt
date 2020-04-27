package tj.rs.devteam.readcounter.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import tj.rs.devteam.readcounter.R
import tj.rs.devteam.readcounter.databinding.ActivityMainBinding
import tj.rs.devteam.readcounter.ui.history.HistoryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.readCount.observe(this, Observer {
            textView.text = it.toString()
        })

        mb_history.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }
}
