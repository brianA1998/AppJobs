package com.example.appjobs.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.appjobs.R
import com.example.appjobs.data.remote.auth.AuthDataSource
import com.example.appjobs.databinding.FragmentProfileBinding
import com.example.appjobs.domain.auth.AuthRepoImpl
import com.example.appjobs.presentation.auth.AuthViewModel
import com.example.appjobs.presentation.auth.AuthViewModelFactory


class SetupProfileFragment : Fragment(R.layout.fragment_setup_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<AuthViewModel> {
        AuthViewModelFactory(AuthRepoImpl(AuthDataSource()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

    }

}