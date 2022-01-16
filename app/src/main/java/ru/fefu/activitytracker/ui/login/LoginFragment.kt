package ru.fefu.activitytracker.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.toolbar.setNavigationOnClickListener { onBackClicked() }
        binding.btnLogin.setOnClickListener { onLoginClicked() }

        return binding.root
    }

    private fun onLoginClicked(){
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
    }

    private fun onBackClicked() {
        findNavController().navigateUp()
    }

}