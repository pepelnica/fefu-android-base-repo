package ru.fefu.activitytracker.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.databinding.FragmentActivitiesBinding
import ru.fefu.activitytracker.databinding.FragmentLoginBinding

class ActivitiesFragment : Fragment() {

    private lateinit var binding: FragmentActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivitiesBinding.inflate(inflater, container, false)


        return binding.root
    }

}