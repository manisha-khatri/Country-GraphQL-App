package com.example.graphqlapp.domain.usecase

import com.example.graphqlapp.data.repository.CountryRepository
import com.example.graphqlapp.data.repository.CountryRepositoryImpl

class GetCountriesUseCase(
    private val repository: CountryRepository = CountryRepositoryImpl()
) {
    suspend operator fun invoke() = repository.getCountries()
}