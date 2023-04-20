package com.example.counter.Presenter

import android.graphics.Color
import android.widget.Toast
import com.example.counter.Model.Model
import com.example.counter.View.CounterView

class Presenter {

    var model = Model()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.showCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15) {
            view.changeTextColor(Color.GREEN)
        }
    }

    fun decrement() {
        model.decrement()
        view.showCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 14) {
            view.changeTextColor(Color.BLACK)
        }
    }


    fun attachView(viewFromActivity: CounterView) {
        view = viewFromActivity
    }
}