package com.example.exampleinterview.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleinterview.data.entities.Post
import com.example.exampleinterview.databinding.ItemLayoutBinding


class CustomAdapter(private val dataSet: Array<Post>) :
    RecyclerView.Adapter<CustomAdapter.CardViewHolder>() {

    class CardViewHolder(private val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(post: Post) {
            itemBinding.titleCard.text = post.title
            itemBinding.bodyCard.text = post.body
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val itemBinding =
            ItemLayoutBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false)
        return CardViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {
        val paymentBean: Post = dataSet[position]
        viewHolder.bind(paymentBean)
    }


    override fun getItemCount() = dataSet.size

}
