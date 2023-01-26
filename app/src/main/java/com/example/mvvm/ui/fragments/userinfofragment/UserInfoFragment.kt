package com.example.mvvm.ui.fragments.userinfofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private lateinit var binding: FragmentUserInfoBinding
    private val viewModel by viewModels<UserInfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() = with(binding) {
        btnInfo.setOnClickListener {
            viewModel.getUserInfo()
            viewModel.userLiveData.observe(viewLifecycleOwner) { user ->
                tvName.text = user.username
                tvAge.text = user.age.toString()
                tvPassword.text = user.password
                tvEmail.text = user.email
            }
        }
        btnEdit.setOnClickListener{
            findNavController().navigate(R.id.action_userInfoFragment_to_editFragment)
        }
    }
}