package com.osama.starter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.osama.starter.R
import com.osama.starter.databinding.FragmentAddItemDetailsBinding
import com.osama.starter.viewModel.ShoeDetailViewModel
import com.osama.starter.viewModel.ShoesViewModel

class AddItemDetails : Fragment() {

    private val shoesViewModel: ShoesViewModel by activityViewModels()
    private lateinit var detailViewModel: ShoeDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddItemDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_item_details,
            container,
            false)

        detailViewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        binding.cancelButt.setOnClickListener {
            navigateToShoeList()
        }

        binding.saveButt.setOnClickListener {
            if (detailViewModel.validateFields()) {
                val shoe = detailViewModel.buildShoe()
                shoesViewModel.addShoe(shoe)
                navigateToShoeList()
            } else {
                Toast.makeText(context, getString(R.string.empty_fields_warning), Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun navigateToShoeList() {
        findNavController().navigate(AddItemDetailsDirections.actionAddItemDetailsToShoeList())
    }

}