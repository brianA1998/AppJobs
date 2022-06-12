package com.example.appjobs.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appjobs.R
import com.example.appjobs.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        signUp()
    }

    private fun signUp() {


        binding.btnSignup.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val confirmPassword = binding.editTextConfirmPassword.text.toString().trim()
            val email = binding.editTextEmailRegister.text.toString().trim()


            if (validateUserData(
                    password,
                    confirmPassword,
                    email,
                    username
                )
            ) return@setOnClickListener



            Log.d("signUpData", "data : $username , $password , $confirmPassword , $email")

        }
    }

    private fun validateUserData(
        password: String,
        confirmPassword: String,
        email: String,
        username: String
    ): Boolean {
        if (password != confirmPassword) {
            binding.editTextConfirmPassword.error = "Password does not match"
            binding.editTextPassword.error = "Password does not match"
            return true
        }

        if (password.isEmpty()) {
            binding.editTextPassword.error = "password is empty"
            return true
        }

        if (confirmPassword.isEmpty()) {
            binding.editTextConfirmPassword.error = "confirm password is empty"
            return true
        }

        if (email.isEmpty()) {
            binding.editTextEmailRegister.error = "email is empty"
            return true
        }

        if (username.isEmpty()) {
            binding.editTextUsername.error = "username is empty"
            return true
        }
        return false
    }
}