package com.zainco.githubarchcompimitation

import android.app.Activity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.zainco.githubarchcompimitation.databinding.ActivityMainBinding
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding by contentView(R.layout.activity_main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.edit.setText("Zain")
    }

    fun <R : Activity, T : ViewDataBinding> contentView(
        @LayoutRes
        layoutRes: Int
    ): SetContentView<R, T> {
        return SetContentView(layoutRes)
    }

    class SetContentView<in R : Activity, T : ViewDataBinding>(
        @LayoutRes
        var layoutRes: Int
    ) {
        operator fun getValue(thisRef: R, property: KProperty<*>): T {
            return DataBindingUtil.setContentView<T>(thisRef, layoutRes)
        }

        operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        }
    }
}


