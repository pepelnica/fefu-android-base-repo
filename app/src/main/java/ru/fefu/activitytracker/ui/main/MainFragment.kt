package ru.fefu.activitytracker.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val navController = (childFragmentManager.findFragmentById(R.id.cvMain) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

        return binding.root
    }

}