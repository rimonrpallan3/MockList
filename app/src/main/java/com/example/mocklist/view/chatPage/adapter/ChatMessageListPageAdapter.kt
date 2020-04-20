package com.example.mocklist.view.chatPage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mocklist.databinding.ChatItemLeftBinding
import com.example.mocklist.databinding.ChatItemRightBinding
import com.example.mocklist.model.Chat
import com.example.mocklist.view.BaseRecyclerAdapter
import com.example.mocklist.view.chatPage.adapter.viewholder.ChatMessageListViewHolder
import com.example.mocklist.view.chatPage.adapter.viewholder.ChatUserListViewHolder
import com.example.mocklist.viewobservers.chatPageViewObserver.adapter.viewholder.ChatUserItemViewObserver
import com.example.mocklist.viewobservers.chatPageViewObserver.adapter.viewholder.ChatUserMessageItemLeftViewObserver
import com.example.mocklist.viewobservers.chatPageViewObserver.adapter.viewholder.ChatUserMessageItemRightViewObserver

class ChatMessageListPageAdapter() : BaseRecyclerAdapter<Chat, ChatMessageListViewHolder>() {
    val MSG_TYPE_LEFT = 0
    val MSG_TYPE_RIGHT = 1
    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup,
        viewType: Int
    ): ChatMessageListViewHolder {
        val binding = ChatItemLeftBinding.inflate(inflater, container, false)
        binding.data = ChatUserMessageItemLeftViewObserver()
        return ChatMessageListViewHolder(binding, container.context)
       /* if(viewType==MSG_TYPE_LEFT) {
            val binding = ChatItemLeftBinding.inflate(inflater, container, false)
            binding.data = ChatUserMessageItemLeftViewObserver()
            return ChatUserListViewHolder(binding, container.context)
        }else if(viewType ==MSG_TYPE_RIGHT){
            val binding = ChatItemRightBinding.inflate(inflater, container, false)
            binding.data =
                ChatUserMessageItemRightViewObserver()
            return ChatUserListViewHolder(binding, container.context)
        }*/


    }




}