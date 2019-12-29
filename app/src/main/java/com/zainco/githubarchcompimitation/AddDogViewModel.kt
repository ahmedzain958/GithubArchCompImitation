package com.zainco.githubarchcompimitation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import kotlin.reflect.KProperty


class Dog {
    val name: String = ""
}

class AddDogViewModel :  ViewModel() {
    var auth: AuthForm = AuthForm()
    class BindableDelegate<in R : BaseObservable, T : Any>(
        private var value: T,
        private val bindingEntry: Int
    ) {
        operator fun getValue(thisRef: R, property: KProperty<*>): T = value
        operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
            this.value = "Zain" as T
            thisRef.notifyPropertyChanged(bindingEntry)
        }

    }
}

class AuthForm : BaseObservable() {
    @get:Bindable
    var dogName by AddDogViewModel.BindableDelegate("Zain", BR.dogName)

    init {
        dogName = "Zain"
    }
}
