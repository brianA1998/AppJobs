package com.example.appjobs.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appjobs.core.BaseViewHolder
import com.example.appjobs.data.model.Publication
import com.example.appjobs.databinding.PublicationItemViewBinding

class HomeScreenAdapter(private val publicationList: List<Publication>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PublicationItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is HomeScreenViewHolder -> holder.bind(publicationList[position])
        }
    }

    override fun getItemCount(): Int = publicationList.size


    private inner class HomeScreenViewHolder(
        val binding: PublicationItemViewBinding,
        val context: Context
    ) : BaseViewHolder<Publication>(binding.root) {
        override fun bind(item: Publication) {
            Glide.with(context).load(item.publication_image).centerCrop()
                .into(binding.publicationImage)
            Glide.with(context).load(item.profile_picture).centerCrop()
                .into(binding.profilePicture)
            binding.profileName.text = item.profile_name
            binding.publicationTimestamp.text = "Hace 2 horas"
        }

    }
}