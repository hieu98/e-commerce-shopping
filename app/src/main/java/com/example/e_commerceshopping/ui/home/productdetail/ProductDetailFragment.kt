package com.example.e_commerceshopping.ui.home.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentProductDetailBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.isActive
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import kotlin.coroutines.resume

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding, MainActivity>() {

    private lateinit var detailAdapter : ProductDetailAdapter

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProductDetailBinding = FragmentProductDetailBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailAdapter = ProductDetailAdapter().apply { stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY }
    }

    override fun setupView() {
        binding.apply {
            showBottomNav(false)
            header.ivNavigateBefore.onClick {
                popBackStack()
            }
            header.btnDelete.setImageResource(R.drawable.ic_favorite)

            btnAddToCart.onClick {
                popBackStack()
            }
            viewpager2.adapter = detailAdapter
            detailAdapter.submitList(
                listOf(
                    R.drawable.img_no_favorite,
                    R.drawable.img_no_favorite,
                    R.drawable.img_no_favorite,
                    R.drawable.img_no_favorite,
                    R.drawable.img_no_favorite
                )
            )
            wormDot.attachTo(viewpager2)
        }
    }

    override fun setupData() {

    }
}