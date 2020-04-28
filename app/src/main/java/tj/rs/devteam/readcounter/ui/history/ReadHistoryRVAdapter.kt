package tj.rs.devteam.readcounter.ui.history

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tj.rs.devteam.readcounter.databinding.RvReadItemBinding
import tj.rs.devteam.readcounter.model.Read

/**
 * @author Rustam Safarov (RS)
 * created at 26.04.2020
 * (c) 2020 RS DevTeam
 */

class ReadHistoryRVAdapter(private var items: List<Read>) :
    RecyclerView.Adapter<ReadHistoryRVAdapter.ReadHistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadHistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvReadItemBinding.inflate(layoutInflater, parent, false)
        return ReadHistoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ReadHistoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun replaceData(data: List<Read>) {
        items = data
        notifyDataSetChanged()
        Log.i("ReadHistoryRVAdapter", "data replaced, new data size: " + data.size)
    }

    inner class ReadHistoryViewHolder(private var binding: RvReadItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(read: Read) {
            binding.read = read
        }
    }
}