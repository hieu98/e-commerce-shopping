package com.example.e_commerceshopping.base.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.e_commerceshopping.ui.MainActivity
import timber.log.Timber

abstract class BaseFragment<B : ViewBinding, A : Any?> : Fragment() {
    private var _binding: B? = null
    protected val binding: B get() = _binding!!
    protected open var handler: A? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        @Suppress("UNCHECKED_CAST")
        this.handler = this.activity as? A
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            val observer = Observer<LifecycleOwner?> {
                it ?: return@Observer

                it.lifecycle.addObserver(object : DefaultLifecycleObserver {

                    override fun onCreate(owner: LifecycleOwner) {
                        super.onCreate(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onCreate")
                    }

                    override fun onStart(owner: LifecycleOwner) {
                        super.onStart(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onStart")
                    }

                    override fun onResume(owner: LifecycleOwner) {
                        super.onResume(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onResume")
                    }

                    override fun onPause(owner: LifecycleOwner) {
                        super.onPause(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onPause")
                    }

                    override fun onStop(owner: LifecycleOwner) {
                        super.onStop(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onStop")
                    }

                    override fun onDestroy(owner: LifecycleOwner) {
                        super.onDestroy(owner)
                        Timber.tag("[VIEW_DEBUG]").d("${this@BaseFragment}::onDestroy")
                    }
                })
            }

            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onCreate")
                viewLifecycleOwnerLiveData.observeForever(observer)
            }

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onStart")
            }

            override fun onResume(owner: LifecycleOwner) {
                super.onResume(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onResume")
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onPause")
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onStop")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                Timber.tag("[DEBUG]").d("${this@BaseFragment}::onDestroy")
                viewLifecycleOwnerLiveData.removeObserver(observer)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = onInflateView(inflater, container)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupData()
    }

    protected abstract fun onInflateView(inflater: LayoutInflater, container: ViewGroup?): B
    protected abstract fun setupView()
    protected abstract fun setupData()

    fun showToolbar(isShow: Boolean) {
        if (activity is MainActivity) {
            (activity as MainActivity).showToolbar(isShow)
        }
    }

    fun showBottomNav(isShow: Boolean) {
        if (activity is MainActivity) {
            (activity as MainActivity).showBottomNav(isShow)
        }
    }

    fun showLoading(isShow: Boolean) {
        (activity as? BaseActivity<*>)?.showLoading(isShow)
    }

    fun navigateTo(
        id: Int,
        bundle: Bundle? = null,
        popUpToId: Int? = null,
        isInclusive: Boolean? = null,
    ) {
        val options = NavOptions.Builder()
        if (popUpToId != null && isInclusive != null) {
            options.setPopUpTo(popUpToId, isInclusive)
        }
        findNavController().navigate(id, bundle)
    }

    fun navigateToNoAnimation(
        id: Int,
        bundle: Bundle? = null,
        popUpToId: Int? = null,
        isInclusive: Boolean? = null,
    ) {
        val options = NavOptions.Builder()
        if (popUpToId != null && isInclusive != null) {
            options.setPopUpTo(popUpToId, isInclusive)
        }
        findNavController().navigate(id, bundle, options.build())
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as? BaseActivity<*>)?.hideLoading()
    }

}