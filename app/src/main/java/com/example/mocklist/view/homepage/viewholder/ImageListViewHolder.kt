package com.example.mocklist.view.homepage.viewholder

import com.bigvand.surfboard.utils.setRxOnClickListener
import com.bigvand.surfboard.view.BaseViewHolderItem
import com.example.mocklist.databinding.ImageListItemBinding
import com.example.mocklist.model.Content

class ImageListViewHolder(private  val mBinding: ImageListItemBinding)
    : BaseViewHolderItem<Content>(mBinding.root) {

    override fun onCreated() {

    }

    override fun onBind(data: Content) {
        mBinding.data!!.setData(data)
        //itemView.ivPhotoId.load(data?.imgUri)

        itemView.setRxOnClickListener {
        }
    }

}