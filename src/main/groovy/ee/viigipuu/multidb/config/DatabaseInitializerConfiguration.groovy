package ee.viigipuu.multidb.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException

@Configuration
class DatabaseInitializerConfiguration {

    @Bean
    DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(primaryDataSource)
        initializeDatabase(primaryDataSource, "schema-primary.sql", "data-primary.sql")
        transactionManager
    }

    @Bean
    DataSourceTransactionManager secondaryTransactionManager(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(secondaryDataSource)
        initializeDatabase(secondaryDataSource, "schema-secondary.sql", "data-secondary.sql")
        transactionManager
    }

    private void initializeDatabase(DataSource dataSource, String schemaFile, String dataFile) {
        Resource schemaResource = new ClassPathResource(schemaFile)
        Resource dataResource = new ClassPathResource(dataFile)
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schemaResource, dataResource)
        try (Connection connection = dataSource.getConnection()) {
            populator.populate(connection)
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database with schema: " + schemaFile + " and data: " + dataFile, e)
        }
    }
}
