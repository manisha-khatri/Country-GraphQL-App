package com.example.graphqlapp.domain.usecase

import com.example.graphqlapp.data.repository.CountryRepository
import com.example.graphqlapp.data.repository.CountryRepositoryImpl

class GetCountryByCodeUseCase(
    private val repository: CountryRepository = CountryRepositoryImpl()
) {
    suspend operator fun invoke(code: String) = repository.getCountryByCode(code)
}
