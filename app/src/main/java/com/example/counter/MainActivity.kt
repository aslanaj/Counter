package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.Presenter.Presenter
import com.example.counter.View.CounterView
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
        presenter.attachView(this)
    }

    private fun listener() {
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.apply {
            tvCount.text = count.toString()
        }
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(Color: Int) {
        binding.tvCount.setTextColor(Color)
    }
}
