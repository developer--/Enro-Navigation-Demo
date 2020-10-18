package com.dev01.enronavigationdemo.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev01.enronavigationdemo.R
import com.dev01.enronavigationdemo.ui.home.HomeFragment
import com.dev01.enronavigationdemo.ui.home.HomeNavigationKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_notifications.*
import nav.enro.annotations.NavigationDestination
import nav.enro.core.NavigationKey
import nav.enro.core.forward
import nav.enro.core.navigationHandle

@Parcelize
class NotificationKey : NavigationKey

@NavigationDestination(key = NotificationKey::class)
class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    val navigation by navigationHandle<HomeNavigationKey>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        textView.setOnClickListener {
            navigation.forward(HomeNavigationKey())
        }


        return root
    }
}