package com.qingmei2.sample.ui.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.qingmei2.sample.common.loadings.CommonLoadingViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

const val LOGIN_MODULE_TAG = "LOGIN_MODULE_TAG"

val loginKodeinModule = Kodein.Module(LOGIN_MODULE_TAG) {

    bind<LoginViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        ViewModelProviders
                .of((context).activity!!, LoginViewModelFactory(instance()))
                .get(LoginViewModel::class.java)
    }

    bind<CommonLoadingViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        CommonLoadingViewModel.instance()
    }

    bind<LoginRemoteDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LoginRemoteDataSource(instance())
    }

    bind<LoginLocalDataSource>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LoginLocalDataSource(instance(), instance())
    }

    bind<LoginDataSourceRepository>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LoginDataSourceRepository(instance(), instance())
    }
}