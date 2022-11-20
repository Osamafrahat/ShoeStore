package com.osama.starter.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.osama.starter.R
import com.osama.starter.databinding.FragmentShoeListBinding
import com.osama.starter.databinding.ItemShoeBinding
import com.osama.starter.models.Shoe
import com.osama.starter.viewModel.ShoesViewModel
import kotlinx.android.synthetic.main.item_shoe.*

class ShoeList : Fragment() {


    private val viewModel: ShoesViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setHasOptionsMenu(true)

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListToAddItemDetails())
        }

        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList ->
            for (shoe in shoesList) {
                addShoeToView(container, shoe)
            }
        })

        return binding.root
    }


    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val shoeBinding: ItemShoeBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_shoe, container, false
        )
        shoeBinding.shoe = shoe
        binding.shoeListLinearLayout.addView(shoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListDirections.actionShoeListToLogIn())
        return true
    }
}