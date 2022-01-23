package ru.fefu.activitytracker.ui.activitydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActivitiesBinding
import ru.fefu.activitytracker.databinding.FragmentActivityDetailsBinding
import ru.fefu.activitytracker.databinding.FragmentLoginBinding
import ru.fefu.activitytracker.databinding.FragmentProfileBinding
import ru.fefu.activitytracker.domain.entity.ActivityType

class ActivityDetailsFragment : Fragment() {

    companion object {
        const val ACTIVITY_NAME: String = "ACTIVITY_NAME"
        const val SCREEN_TYPE: String = "SCREEN_TYPE"
    }

    private lateinit var binding: FragmentActivityDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityDetailsBinding.inflate(inflater, container, false)
        binding.toolbar.title = requireArguments().getString(ACTIVITY_NAME)

        binding.tvDistance.text = "14.32 км"
        binding.tvActivityDate.text = "14 часов назад"
        binding.tvTiming.text = "1 ч 42 мин"
        binding.tvStartValue.text = "14:49"
        binding.tvFinishValue.text = "16:31"
        binding.tvAuthorTag.text = "@tvAuthorTag"
        binding.toolbar.setOnClickListener { onBackClicked() }

        when (ActivityType.values()[requireArguments().getInt(SCREEN_TYPE)]) {
            ActivityType.MY -> {
                binding.tvAuthorTag.visibility = View.GONE
                binding.tilComment.visibility = View.VISIBLE
                binding.tvCommentValue.visibility = View.GONE
            }
            ActivityType.COMMUNITY -> {
                binding.tvAuthorTag.visibility = View.VISIBLE
                binding.tilComment.visibility = View.GONE
                binding.tvCommentValue.visibility = View.VISIBLE
                binding.tvCommentValue.text = "Я бежал очень сильно, ты так \u2028не сможешь"
            }

        }

        return binding.root
    }

    private fun onBackClicked() {
        findNavController().navigateUp()
    }

}