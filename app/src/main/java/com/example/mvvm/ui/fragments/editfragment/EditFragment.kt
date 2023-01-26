package com.example.mvvm.ui.fragments.editfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private val viewModel by viewModels<EditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupListener()
    }

    private fun getData() = with(binding) {
        viewModel.getInfo().observe(viewLifecycleOwner) {
            edName.setText(it.username)
            edAge.setText(it.age.toString())
            edPassword.setText(it.password)
            edEmail.setText(it.email)
        }
    }

    private fun setupListener() = with(binding) {
        btmEdit.setOnClickListener {
            if (edName.text.isEmpty()) {
                edName.error = "Заполните поле"
            } else if (edAge.text.isEmpty()) {
                edAge.error = "Заполните поле"
            } else if (edPassword.text.isEmpty()) {
                edPassword.error = "Заполните поле"
            } else if (edEmail.text.isEmpty()) {
                edEmail.error = "Заполните поле"
            } else {
                val name = edName.text.toString().trim()
                val age = edAge.text.toString().trim()
                val password = edPassword.text.toString().trim()
                val email = edEmail.text.toString().trim()

                viewModel.updateUserInfo(name, age.toInt(), email, password)
                findNavController().navigateUp()
            }
        }
    }
}