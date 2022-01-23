package ru.fefu.activitytracker.ui.myactivity

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.domain.entity.ActivitiesEntity
import ru.fefu.activitytracker.domain.entity.ActivityEntity
import ru.fefu.activitytracker.domain.entity.MyActivityEntity
import ru.fefu.activitytracker.domain.entity.UserActivityEntity

class MyActivityAdapter(
    private val resources: Resources,
    private val onActivityClickListener: () -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val activities = mutableListOf<ActivitiesEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> DateHolder(view.inflate(R.layout.list_item_date_activity, parent, false))
            1 -> MyActivityHolder(view.inflate(R.layout.list_item_acitivity, parent, false))
            else -> DateHolder(view.inflate(R.layout.list_item_date_activity, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            0 -> DateHolder(holder.itemView).setDate(activities[0].date, true)
            3 -> DateHolder(holder.itemView).setDate(activities[1].date)
            1 -> MyActivityHolder(holder.itemView).setActivity(activities[0].activity[0])
            2 -> MyActivityHolder(holder.itemView).setActivity(activities[0].activity[1])
            4 -> MyActivityHolder(holder.itemView).setActivity(activities[1].activity[0])
            5 -> MyActivityHolder(holder.itemView).setActivity(activities[1].activity[1])
            else -> 0
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0, 3 -> 0
            1, 2, 4, 5 -> 1
            else -> 0
        }
    }

    override fun getItemCount(): Int =
        activities.size + activities.fold(0) { sum, item -> sum + item.activity.size }

    inner class MyActivityHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun setActivity(activity: ActivityEntity) {
            with((view.findViewById(R.id.tvAuthorTag) as TextView)) {
                this.isVisible = activity is UserActivityEntity
                this.text = if (activity is UserActivityEntity) activity.userTag else ""
            }
            (view.findViewById(R.id.tvDistance) as TextView).text = activity.distance
            (view.findViewById(R.id.tvTiming) as TextView).text = activity.duration
            (view.findViewById(R.id.tvActivity) as TextView).text = activity.activityType
            (view.findViewById(R.id.tvActivityDate) as TextView).text = activity.timing
            view.setOnClickListener { onActivityClickListener.invoke() }
        }

    }

    inner class DateHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun setDate(date: String, isFirst: Boolean = false) {
            if (isFirst) view.setPadding(
                view.paddingLeft,
                resources.getDimensionPixelOffset(R.dimen.date_padding_top),
                view.paddingRight,
                view.paddingBottom
            )
            ((view.findViewById(R.id.tvDate)) as TextView).text = date
        }

    }

    fun setActivities(activities: List<ActivitiesEntity>) {
        this.activities.clear()
        this.activities.addAll(activities)
        notifyDataSetChanged()
    }

}