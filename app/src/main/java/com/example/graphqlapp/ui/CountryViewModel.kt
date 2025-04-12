package com.example.graphqlapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlapp.data.repository.CountryRepositoryImpl
import com.example.graphqlapp.domain.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val repository = CountryRepositoryImpl()

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            val result = repository.getCountries()
            _countries.value = result
        }
    }
}