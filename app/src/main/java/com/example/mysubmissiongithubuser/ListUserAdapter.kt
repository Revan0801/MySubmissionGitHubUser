package com.example.mysubmissiongithubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysubmissiongithubuser.databinding.ItemRowGituserBinding

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowGituserBinding.inflate(LayoutInflater.
        from(viewGroup.context), viewGroup, false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user: User = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .circleCrop()
            .into(holder.binding.imgItemAvatar)
        holder.binding.tvItemName.text = user.name
        holder.binding.tvItemUsername.text = user.username

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(var binding: ItemRowGituserBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemCallBack(onItemCallClickBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemCallClickBack
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: User)
    }

}