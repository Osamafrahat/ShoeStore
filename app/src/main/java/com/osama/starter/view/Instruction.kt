package com.osama.starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.osama.starter.R
import com.osama.starter.databinding.FragmentInstructionBinding

class Instruction : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding= DataBindingUtil.inflate(inflater,
            R.layout.fragment_instruction,
            container,
            false
        )

        binding.nextButt.setOnClickListener {
            findNavController().navigate(InstructionDirections.actionInstructionToShoeList())
        }

        return binding.root

    }
}