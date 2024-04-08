# Druid Client

## Usage

1. Add dependency

```gradle
dependencies {
    implementation("com.genten.druid.client:druid-client:1.0.0-SNAPSHOT")
}
```

2. Configure Client (DI)

```kotlin

@Configuration
open class DruidConfig(
    @Value("${druid.url}") private val baseUrl: String,
    @Value("${druid.username}") private val username: String,
    @Value("${druid.password}") private val password: String,
) {

    @Bean
    fun druidClientConfig(): DruidClientConfig = DruidClientConfig(baseUrl, username, password)
}
```

3. Usage

```kotlin

@Service
class DruidRestClient(private val druidClient: DruidClient) {

    data class YourResponseClass(val id: String)

    fun query(query: String = "SELECT id FROM specific_table"): List<YourResponseClass> = druidClient.query(query)
}
```
