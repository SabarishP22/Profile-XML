package com.example.profilesample.base

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.profilesample.R

open class BaseFragment : Fragment() {

    private val commonNavOptions: NavOptions by lazy {
        NavOptions.Builder()
            .setEnterAnim(R.anim.enter_anim)
            .setExitAnim(R.anim.exit_anim)
            .setPopEnterAnim(R.anim.pop_enter_anim)
            .setPopExitAnim(R.anim.pop_exit_anim)
            .build()
    }

    protected fun navigateTo(fragmentId: Int, bundle: Bundle? = null) {
        findNavController().navigate(fragmentId, bundle, commonNavOptions)
    }

    private fun navigateWithCustomAnimation(fragmentId: Int, bundle: Bundle? = null) {
        findNavController().navigate(fragmentId, bundle)
    }

    protected fun popBack() {
        findNavController().popBackStack()
    }

    protected fun popBackToParticularFragment(fragmentId: Int) {
        findNavController().popBackStack(fragmentId, false)
    }

    protected fun closeAppOnBackPress() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    protected fun closeApp() {
        activity?.finish()
    }

    protected fun showToast(message: String) {
        context.let {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}