package com.curso.android.app.miappticmas.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.miappticmas.databinding.ActivityMainBinding
import com.curso.android.app.miappticmas.view.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonComparar.setOnClickListener {
            val num1 = binding.editTextNum1.text.toString().toInt()
            val num2 = binding.editTextNum2.text.toString().toInt()
            mainViewModel.compareNumbers(num1, num2)
        }

        mainViewModel.message.observe(this) { message ->
            binding.textViewMensaje.text = message
        }

//        mainViewModel.compare.observe(this) { compare ->
//            val result = if (compare.number == 1) "Los números son iguales" else "Los números son diferentes"
//            binding.textViewMensaje.text = result
//        }
    }
}




