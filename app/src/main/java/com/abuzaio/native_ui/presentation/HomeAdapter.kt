package com.abuzaio.native_ui.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abuzaio.native_ui.R
import com.abuzaio.native_ui.data.Result
import com.abuzaio.native_ui.databinding.ItemHomeBinding
import com.abuzaio.native_ui.presentation.HomeAdapter.HomeViewHolder

class HomeAdapter(private val results: List<Result>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = HomeAdapterViewModel(results[holder.adapterPosition])
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return results.count();
    }

    inner class HomeViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)
}