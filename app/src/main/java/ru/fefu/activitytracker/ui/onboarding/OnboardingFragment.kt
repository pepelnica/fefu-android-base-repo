package ru.fefu.activitytracker.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentLoginBinding
import ru.fefu.activitytracker.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.btnRegistration.setOnClickListener { onRegistrationClicked() }
        binding.tvLogin.setOnClickListener { onLoginClicked() }

        return binding.root
    }

    private fun onRegistrationClicked() {
        findNavController().navigate(R.id.action_onboardingFragment_to_registrationFragment)
    }

    private fun onLoginClicked() {
        findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
    }

}