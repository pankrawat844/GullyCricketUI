package com.kliff.gullycricket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.models.MatchList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_match.view.*

class MatchListAdapter :
    ListAdapter<MatchList, MatchListAdapter.ViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MatchList>() {
            override fun areItemsTheSame(oldItem: MatchList, newItem: MatchList): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MatchList, newItem: MatchList): Boolean {
                return oldItem.team1Image == newItem.team1Image && oldItem.team2Image == newItem.team2Image
                        && oldItem.team1Name == newItem.team1Name && oldItem.team2Name == newItem.team2Name
                        && oldItem.inningOne == newItem.inningOne && oldItem.inningTwo == newItem.inningTwo
                        && oldItem.inningThree == newItem.inningThree && oldItem.inningFour == newItem.inningFour
            }
        }
    }

    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match, parent, false)
        return ViewHolder(view)
    }

    fun getMatchAt(position: Int): MatchList {
        return getItem(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData: MatchList = getItem(position)

        Picasso.get().load(currentData.team1Image).fit()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.imgTeamA)
        Picasso.get().load(currentData.team2Image).fit()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.imgTeamB)

        holder.itemView.tvTeamA.text = currentData.team1Name
        holder.itemView.tvTeamB.text = currentData.team2Name
        holder.itemView.tvTeamARuns.text = currentData.inningOne
        holder.itemView.tvTeamBRuns.text = currentData.inningTwo
        holder.itemView.tvTeamAOvers.text = currentData.inningThree
        holder.itemView.tvTeamBOvers.text = currentData.inningFour
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position))
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(matchList: MatchList)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}