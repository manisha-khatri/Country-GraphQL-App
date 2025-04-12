package com.example.graphqlapp.data.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.graphqlapp.CountriesQuery
import com.example.graphqlapp.data.remote.ApolloClientProvider
import com.example.graphqlapp.domain.Country

class CountryRepositoryImpl : CountryRepository {

    private val apolloClient = ApolloClientProvider.client

    override suspend fun getCountries(): List<Country> {
        val response: ApolloResponse<CountriesQuery.Data> = apolloClient.query(CountriesQuery()).execute()
        return response.data?.countries?.map {
            Country(name = it.name , code = it.code, emoji = it.emoji)
        } ?: emptyList()
    }
}
