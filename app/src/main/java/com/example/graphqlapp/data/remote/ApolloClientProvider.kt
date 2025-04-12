package com.example.graphqlapp.data.remote

import com.apollographql.apollo3.ApolloClient

object ApolloClientProvider {
    val client: ApolloClient by lazy {
        ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }
}
