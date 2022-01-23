package ru.fefu.activitytracker.ui.usersactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentUsersActivityBinding
import ru.fefu.activitytracker.domain.entity.ActivitiesEntity
import ru.fefu.activitytracker.domain.entity.ActivityType
import ru.fefu.activitytracker.domain.entity.MyActivityEntity
import ru.fefu.activitytracker.domain.entity.UserActivityEntity
import ru.fefu.activitytracker.ui.activitydetails.ActivityDetailsFragment
import ru.fefu.activitytracker.ui.myactivity.MyActivityAdapter

class UsersActivityFragment : Fragment(R.layout.fragment_users_activity) {

    private lateinit var binding: FragmentUsersActivityBinding

    val data = listOf(
        ActivitiesEntity(
            "Вчера",
            listOf(
                UserActivityEntity(
                    "14.32 км",
                    "2 часа 46 минут",
                    "Серфинг \uD83C\uDFC4",
                    "14 часов назад",
                    "@van_darkholme"
                ),
                UserActivityEntity(
                    "1 000 м",
                    "60 минут",
                    "Велосипед  \uD83D\uDEB2",
                    "29.05.2022",
                    "@van_darkholme"
                )
            )
        ),
        ActivitiesEntity(
            "Май 2022 года",
            listOf(
                UserActivityEntity(
                    "14.32 км",
                    "2 часа 46 минут",
                    "Серфинг \uD83C\uDFC4",
                    "14 часов назад",
                    "@van_darkholme"
                ),
                UserActivityEntity(
                    "1 000 м",
                    "60 минут",
                    "Велосипед  \uD83D\uDEB2",
                    "29.05.2022",
                    "@van_darkholme"
                )
            )
        )
    )

    private val activityAdapter by lazy {
        MyActivityAdapter(resources, ::onActivityClicked).apply {
            setActivities(data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersActivityBinding.inflate(inflater, container, false)

        binding.rvUsersActivity.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = activityAdapter
        }


        return binding.root
    }

    private fun onActivityClicked() {
        findNavController().navigate(
            R.id.action_activitiesFragment_to_activityDetailsFragment,
            bundleOf(ActivityDetailsFragment.ACTIVITY_NAME to "Велосипед \uD83D\uDEB2", ActivityDetailsFragment.SCREEN_TYPE to ActivityType.COMMUNITY.ordinal)
        )
    }

}
