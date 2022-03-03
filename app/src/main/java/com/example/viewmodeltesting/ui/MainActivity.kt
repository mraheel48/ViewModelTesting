package com.example.viewmodeltesting.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeltesting.databinding.ActivityMainBinding
import com.example.viewmodeltesting.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val model = ViewModelProvider(this)[MainViewModel::class.java]

        binding.textView.text = "${model.getCurrentCount()}"

        binding.button.setOnClickListener {
            model.getUpdatedCount()
            binding.textView.text = "${model.getCurrentCount()}"
        }

        binding.button2.setOnClickListener {
            model.removeUpdatedCount()
            binding.textView.text = "${model.getCurrentCount()}"
        }
    }
}