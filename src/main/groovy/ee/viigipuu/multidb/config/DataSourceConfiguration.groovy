package ee.viigipuu.multidb.config

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

import javax.sql.DataSource

@Configuration
class DataSourceConfiguration {

    @Bean
    @Primary
    DataSource dataSource() {
        RoutingDataSource routingDataSource = new RoutingDataSource()
        routingDataSource.setDataSource("primary", primaryDataSource())
        routingDataSource.setDataSource("secondary", secondaryDataSource())
        routingDataSource
    }

    @Bean
    @ConfigurationProperties("spring.datasource.primary")
    DataSourceProperties primaryDataSourceProperties() {
        new DataSourceProperties()
    }

    @Bean
    DataSource primaryDataSource() {
        primaryDataSourceProperties().initializeDataSourceBuilder().build()
    }

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    DataSourceProperties secondaryDataSourceProperties() {
        new DataSourceProperties()
    }

    @Bean
    DataSource secondaryDataSource() {
        secondaryDataSourceProperties().initializeDataSourceBuilder().build()
    }
}
