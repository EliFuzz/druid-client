package com.genten.druid.client

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.reactive.function.client.WebClient

class DruidClientConfig(private val url: String, private val username: String, private val password: String) {
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader("Content-Type", APPLICATION_JSON_VALUE)
            .defaultHeader("Accept", APPLICATION_JSON_VALUE)
            .defaultHeaders { header -> header.setBasicAuth(username, password) }
            .build()
    }
}
