package com.osama.starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.osama.starter.R
import com.osama.starter.databinding.FragmentLogInBinding
import kotlinx.android.synthetic.main.fragment_log_in.*


class LogIn : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLogInBinding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_log_in,
            container,
            false)


        binding.signInButt.setOnClickListener {
            navigateToWelcomeFragment()
        }

        binding.signUpButt.setOnClickListener {
            navigateToWelcomeFragment()
        }

        return binding.root
    }

    private fun navigateToWelcomeFragment() {

        findNavController().navigate(LogInDirections.actionLogInToWelcome())
    }
}