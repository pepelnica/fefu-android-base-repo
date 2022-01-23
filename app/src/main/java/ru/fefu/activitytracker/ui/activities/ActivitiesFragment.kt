package ru.fefu.activitytracker.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActivitiesBinding
import ru.fefu.activitytracker.databinding.FragmentLoginBinding
import ru.fefu.activitytracker.ui.myactivity.MyActivityFragment
import ru.fefu.activitytracker.ui.usersactivity.UsersActivityFragment

class ActivitiesFragment : Fragment() {

    private lateinit var binding: FragmentActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        binding.vpActivities.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tlActivities, binding.vpActivities) { tab, position ->
            tab.text = resources.getStringArray(R.array.activities_name)[position]
        }.attach()

        return binding.root
    }

    private class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment =
            when (position) {
                0 -> MyActivityFragment()
                1 -> UsersActivityFragment()
                else -> UsersActivityFragment()
            }

    }

}