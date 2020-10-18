package com.dev01.enronavigationdemo.app

import android.app.Application
import nav.enro.annotations.NavigationComponent
import nav.enro.core.controller.NavigationApplication
import nav.enro.core.controller.NavigationController
import nav.enro.core.controller.navigationController

@NavigationComponent
class MyApplication : Application(), NavigationApplication {
    override val navigationController: NavigationController = navigationController()
}