package com.example.graphqlapp.data.repository

import com.example.graphqlapp.domain.model.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
    suspend fun getCountryByCode(code: String): Country?
}