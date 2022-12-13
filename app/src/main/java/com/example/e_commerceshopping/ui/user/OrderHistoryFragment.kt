
package com.example.e_commerceshopping.ui.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentOrderHistoryBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class OrderHistoryFragment : BaseFragment<FragmentOrderHistoryBinding, MainActivity>(){
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrderHistoryBinding = FragmentOrderHistoryBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            header.tvTitle.setText(R.string.history)
            header.btnDelete.visibility = View.GONE
            header.ivNavigateBefore.onClick {
                popBackStack()
            }
            btnStartOrder.onClick{
                popBackStack()
                handler?.switchBottomNavTab(R.id.nav_home)
            }
        }
    }

    override fun setupData() {

    }
}