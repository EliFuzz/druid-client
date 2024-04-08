package com.genten.druid.client

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity

class DruidClient(private val druidClientConfig: DruidClientConfig) {
    fun <T> query(query: String): List<T> =
        druidClientConfig.webClient().post()
            .uri("/druid/v2/sql")
            .bodyValue(HttpEntity("query" to query))
            .retrieve()
            .bodyToFlux(object : ParameterizedTypeReference<T>() {})
            .collectList()
            .blockOptional()
            .orElse(emptyList())
}
