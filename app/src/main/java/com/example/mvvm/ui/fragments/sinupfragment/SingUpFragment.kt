package com.example.mvvm.ui.fragments.sinupfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm.data.local.preferencehelper.UserPreferenceHelper
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentSingUpBinding

class SingUpFragment : Fragment() {

    private lateinit var binding: FragmentSingUpBinding
    private val viewModel by viewModels<SingUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        UserPreferenceHelper.unit(requireContext())
        setupListener()
        openSignUp()
    }

    private fun setupListener() = with(binding) {
        materialButton.setOnClickListener {
            val name = edName.text.toString().trim()
            val age = edAge.text.toString().trim()
            val password = edPassword.text.toString().trim()
            val email = edEmail.text.toString().trim()

            if (name.isEmpty()) {
                edName.error = "Заполните поле"
            } else if (age.isEmpty()) {
                edAge.error = "Заполните поле"
            } else if (email.isEmpty()) {
                edPassword.error = "Заполните поле"
            } else if (password.isEmpty()) {
                edEmail.error = "Заполните поле"
            } else {
                viewModel.signUp(name, age.toInt(), email, password)
                findNavController().navigate(R.id.action_singUpFragment_to_userInfoFragment)
            }
        }
    }

    private fun openSignUp() {
        UserPreferenceHelper.isSignUp = true
    }
}