package com.example.graphqlapp.data.repository

import com.example.graphqlapp.CountriesQuery
import com.example.graphqlapp.CountryByCodeQuery
import com.example.graphqlapp.data.remote.ApolloClientProvider
import com.example.graphqlapp.domain.model.Country

class CountryRepositoryImpl : CountryRepository {
    private val apolloClient = ApolloClientProvider.client

    override suspend fun getCountries(): List<Country> {
        val response = apolloClient.query(CountriesQuery()).execute()
        return response.data?.countries?.map {
            Country(name = it.name, code = it.code, emoji = it.emoji)
        } ?: emptyList()
    }

    override suspend fun getCountryByCode(code: String): Country? {
        val response = apolloClient.query(CountryByCodeQuery(code = code)).execute()
        val country = response.data?.country
        return country?.let { Country(it.name, it.code, it.emoji) }
    }
}
