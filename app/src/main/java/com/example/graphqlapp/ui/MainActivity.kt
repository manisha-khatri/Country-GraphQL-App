package com.example.graphqlapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graphqlapp.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var countryRecyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryRecyclerView = findViewById(R.id.countryRecyclerView)
        countryAdapter = CountryAdapter()
        countryRecyclerView.layoutManager = LinearLayoutManager(this)
        countryRecyclerView.adapter = countryAdapter

        viewModel = ViewModelProvider(this)[CountryViewModel::class.java]

        lifecycleScope.launch {
            viewModel.countries.collectLatest { countries ->
                countryAdapter.submitList(countries)
            }
        }
    }
}