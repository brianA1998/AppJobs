package com.example.appjobs.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.appjobs.R
import com.example.appjobs.core.Resource
import com.example.appjobs.data.remote.home.HomeScreenDataSource
import com.example.appjobs.databinding.FragmentHomeScreenBinding
import com.example.appjobs.domain.home.HomeScreenRepoImpl
import com.example.appjobs.presentation.HomeScreenViewModel
import com.example.appjobs.presentation.HomeScreenViewModelFactory
import com.example.appjobs.ui.home.adapter.HomeScreenAdapter


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel> {
        HomeScreenViewModelFactory(HomeScreenRepoImpl(HomeScreenDataSource()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        viewModel.fetchLatestPublications().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter = HomeScreenAdapter(result.data)
                }

                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio un error ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("ERROR_FIREBASE", "${result.exception}")
                }

            }
        })

    }
}