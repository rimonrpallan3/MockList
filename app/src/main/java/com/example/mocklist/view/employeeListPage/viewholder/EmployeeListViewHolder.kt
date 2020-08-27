package com.example.mocklist.view.homepage.viewholder

import com.example.mocklist.view.BaseViewHolderItem
import com.example.mocklist.R
import com.example.mocklist.databinding.EmployeeListItemBinding
import com.example.mocklist.model.EmployeeListItem
import com.example.mocklist.utils.setRxOnClickListener

class EmployeeListViewHolder(private val mBinding: EmployeeListItemBinding,
                             private var mEmployeeListItem: ((EmployeeListItem?) -> Unit)) : BaseViewHolderItem<EmployeeListItem>(mBinding.root) {

    override fun onCreated() {
        itemView.setRxOnClickListener {
            mEmployeeListItem(data)
        }
    }

    override fun onBind(data: EmployeeListItem) {
        mBinding.data?.setData(data)

    }
}
