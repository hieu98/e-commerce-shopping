package com.example.e_commerceshopping.ui.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentUserBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class UserFragment : BaseFragment<FragmentUserBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding = FragmentUserBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(true)
        binding.apply {
            header.tvTitle.setText(R.string.profile)
            header.btnDelete.visibility = View.GONE
            header.ivNavigateBefore.visibility = View.GONE

            cardOrderHistory.onClick {
                navigateTo(
                    R.id.action_userFragment_to_orderHistoryFragment,
                    null,
                    R.id.nav_user,
                    false
                )
            }
        }
    }

    override fun setupData() {
    }


}