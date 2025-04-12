package com.example.graphqlapp.data.repository

import com.example.graphqlapp.domain.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}