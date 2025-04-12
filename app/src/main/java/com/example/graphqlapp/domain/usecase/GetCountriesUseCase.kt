package com.example.graphqlapp.domain.usecase

import com.example.graphqlapp.data.repository.CountryRepository

class GetCountriesUseCase(private val repository: CountryRepository) {
    suspend operator fun invoke() = repository.getCountries()
}