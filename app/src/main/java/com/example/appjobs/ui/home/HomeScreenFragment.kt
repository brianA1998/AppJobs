package com.example.appjobs.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.appjobs.R
import com.example.appjobs.data.model.Publication
import com.example.appjobs.databinding.FragmentHomeScreenBinding
import com.example.appjobs.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        val postList =
            listOf(
                Publication("profile", "brian", Timestamp.now(), "urlimage"),
                Publication("profile 2", "ezequiel", Timestamp.now(), "urlimage2")
            )
        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }
}