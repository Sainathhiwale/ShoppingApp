package com.examen.shoppingapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.examen.shoppingapp.R
import com.examen.shoppingapp.data.remote.model.Category2
import com.examen.shoppingapp.databinding.FragmentHomeBinding
import com.examen.shoppingapp.utils.Resource
import com.examen.shoppingapp.view.adapter.HomeAdapter
import com.examen.shoppingapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel : HomeViewModel

    @Inject
    lateinit var adapter : HomeAdapter

    private lateinit var binding : FragmentHomeBinding

    private var category2 = mutableListOf<Category2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel.getAllProducts()

        viewModel.products.observe(viewLifecycleOwner){ shop->
            when(shop){
                is Resource.Success -> {
                    adapter.differ.submitList(shop.data)
                    binding.homeRecyclerView.visibility = View.VISIBLE
                    Log.i("HomeFragment","${shop.data}")
                }
                is Resource.Loading -> {
                    //binding.homeRecyclerView.visibility = View.INVISIBLE
                    Log.i("HomeFragment","Loading...")
                }
                is Resource.Error -> {
                    Log.i("HomeFragment","${shop.message}")
                }
            }
        }
        adapter.setOnItemClickListener {
            val toast = Toast.makeText(requireActivity()," item : "+ it.title, Toast.LENGTH_SHORT)
            toast.show()
        }
    }


}