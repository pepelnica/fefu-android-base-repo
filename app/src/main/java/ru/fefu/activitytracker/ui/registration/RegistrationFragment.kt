package ru.fefu.activitytracker.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentLoginBinding
import ru.fefu.activitytracker.databinding.FragmentOnboardingBinding
import ru.fefu.activitytracker.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.toolbar.setNavigationOnClickListener { onBackClicked() }

        return binding.root
    }

    private fun onBackClicked() {
        findNavController().navigateUp()
    }

}