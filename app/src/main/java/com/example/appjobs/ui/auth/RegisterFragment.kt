    package com.example.appjobs.ui.auth

    import android.os.Bundle
    import android.util.Log
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Toast
    import androidx.fragment.app.viewModels
    import androidx.lifecycle.Observer
    import androidx.navigation.fragment.findNavController
    import com.example.appjobs.R
    import com.example.appjobs.core.Result
    import com.example.appjobs.data.remote.auth.AuthDataSource
    import com.example.appjobs.databinding.FragmentRegisterBinding
    import com.example.appjobs.domain.auth.AuthRepoImpl
    import com.example.appjobs.presentation.auth.AuthViewModel
    import com.example.appjobs.presentation.auth.AuthViewModelFactory


    class RegisterFragment : Fragment(R.layout.fragment_register) {

        private lateinit var binding: FragmentRegisterBinding
        private val viewModel by viewModels<AuthViewModel> {
            AuthViewModelFactory(AuthRepoImpl(AuthDataSource()))
        }

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


                createUser(email, password , username)


            }
        }

        private fun createUser(email: String, password: String, username: String) {
            viewModel.signUp(email, password, username).observe(viewLifecycleOwner, Observer { result ->
                when(result){
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnSignup.isEnabled = false
                    }
                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_registerFragment_to_homeScreenFragment)
                    }
                    is Result.Failure -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnSignup.isEnabled = true
                        Toast.makeText(requireContext(), "Error : ${result.exception}", Toast.LENGTH_SHORT).show()
                        Log.d("FAILURE","Error : ${result.exception}")
                    }
                }
            })
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