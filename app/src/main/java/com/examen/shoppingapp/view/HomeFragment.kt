package com.examen.shoppingapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.examen.shoppingapp.R
import com.examen.shoppingapp.data.remote.model.Category2
import com.examen.shoppingapp.databinding.FragmentHomeBinding
import com.examen.shoppingapp.view.adapter.HomeAdapter
import com.examen.shoppingapp.viewmodel.HomeViewModel
import javax.inject.Inject


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
        viewModel.getAllCategories()

    }


}