package com.abuzaio.native_ui.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abuzaio.native_ui.R
import com.abuzaio.native_ui.data.Result
import com.abuzaio.native_ui.presentation.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val results: List<Result>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_home,
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return results.count();
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result) {
            with(itemView) {
                tv_title.text = result.title
                tv_overview.text = result.overview
            }
        }
    }
}