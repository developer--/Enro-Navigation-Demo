package com.dev01.enronavigationdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev01.enronavigationdemo.ui.dashboard.Dashboard
import com.dev01.enronavigationdemo.ui.home.HomeFragment
import com.dev01.enronavigationdemo.ui.home.HomeNavigationKey
import com.dev01.enronavigationdemo.ui.notifications.NotificationKey
import com.dev01.enronavigationdemo.ui.notifications.NotificationsFragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import nav.enro.annotations.NavigationDestination
import nav.enro.core.*
import nav.enro.multistack.MultistackContainer
import nav.enro.multistack.multistackController


@Parcelize
class MainKey : NavigationKey

@NavigationDestination(MainKey::class,allowDefault = true)
class MainActivity : AppCompatActivity() {

    private val navigation by navigationHandle<MainKey> {
        container(R.id.homeContainer) {
            true
        }
    }

//    private val mutlistack by multistackController(
//        MultistackContainer(R.id.homeContainer, Home()),
//        MultistackContainer(R.id.featuresContainer, Features()),
//        MultistackContainer(R.id.profileContainer, Profile())
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    navigation.forward(HomeNavigationKey())
                }
                R.id.navigation_notifications -> {
                    navigation.forward(NotificationKey())
                }
                R.id.navigation_dashboard -> {
                    navigation.forward(Dashboard())
                }

                else -> {}
            }
            true
        }
    }
}