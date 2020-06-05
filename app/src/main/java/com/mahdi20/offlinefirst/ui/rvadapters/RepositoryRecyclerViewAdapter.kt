package com.mahdi20.offlinefirst.ui.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdi20.offlinefirst.databinding.RvItemRepositoryBinding
import com.mahdi20.offlinefirst.ui.uimodels.Repository


class RepositoryRecyclerViewAdapter(
    private var items: ArrayList<Repository>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList: ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: RvItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}

