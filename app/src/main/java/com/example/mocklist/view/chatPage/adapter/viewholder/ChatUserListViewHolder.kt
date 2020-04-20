package com.example.mocklist.view.chatPage.adapter.viewholder

import android.content.Context
import com.example.mocklist.databinding.ChatUserItemBinding
import com.example.mocklist.model.Chat
import com.example.mocklist.model.Chatlist
import com.example.mocklist.model.User
import com.example.mocklist.view.BaseViewHolderItem

class ChatUserListViewHolder(private  val mBinding: ChatUserItemBinding,
                             private val mContext: Context)
    : BaseViewHolderItem<User>(mBinding.root) {

    override fun onCreated() {

    }

    override fun onBind(data: User) {
        //mBinding.data!!.setData(data)
        //itemView.ivPhotoId.load(data?.imgUri)


    }


}