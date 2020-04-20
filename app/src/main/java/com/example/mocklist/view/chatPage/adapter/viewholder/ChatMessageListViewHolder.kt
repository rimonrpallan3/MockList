package com.example.mocklist.view.chatPage.adapter.viewholder

import android.content.Context
import com.example.mocklist.databinding.ChatItemLeftBinding
import com.example.mocklist.model.Chat
import com.example.mocklist.model.Chatlist
import com.example.mocklist.view.BaseViewHolderItem

class ChatMessageListViewHolder(private  val mBinding: ChatItemLeftBinding,
                                private val mContext: Context)
    : BaseViewHolderItem<Chat>(mBinding.root) {

    override fun onCreated() {

    }

    override fun onBind(data: Chat) {
        //mBinding.data!!.setData(data)
        //itemView.ivPhotoId.load(data?.imgUri)


    }


}