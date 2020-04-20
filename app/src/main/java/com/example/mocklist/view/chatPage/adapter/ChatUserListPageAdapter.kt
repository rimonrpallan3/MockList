package com.example.mocklist.view.chatPage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mocklist.databinding.ChatUserItemBinding
import com.example.mocklist.model.User
import com.example.mocklist.view.BaseRecyclerAdapter
import com.example.mocklist.view.chatPage.adapter.viewholder.ChatUserListViewHolder
import com.example.mocklist.viewobservers.chatPageViewObserver.adapter.viewholder.ChatUserItemViewObserver

class ChatUserListPageAdapter() : BaseRecyclerAdapter<User, ChatUserListViewHolder>() {
    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup,
        viewType: Int
    ): ChatUserListViewHolder {
        val binding  = ChatUserItemBinding.inflate(inflater,container, false)
        binding.data =
            ChatUserItemViewObserver()
        return ChatUserListViewHolder(binding, container.context)

    }




}