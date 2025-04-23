package com.example.graphqlapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlapp.domain.model.Country
import com.example.graphqlapp.domain.usecase.GetCountriesUseCase
import com.example.graphqlapp.domain.usecase.GetCountryByCodeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class CountryViewModel : ViewModel() {

    private val getCountryByCodeUseCase = GetCountryByCodeUseCase()
    private val getCountriesUseCase = GetCountriesUseCase()

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val _country = MutableStateFlow<Country?>(null)
    val country: StateFlow<Country?> = _country

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            _countries.value = getCountriesUseCase()
        }
    }

    fun fetchCountry(code: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _country.value = getCountryByCodeUseCase(code)
        }
    }
}