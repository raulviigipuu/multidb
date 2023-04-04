package ee.viigipuu.multidb.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup

import javax.sql.DataSource

class RoutingDataSource extends AbstractRoutingDataSource {

    private final MapDataSourceLookup dataSourceLookup = new MapDataSourceLookup()

    RoutingDataSource() {
        super.setDataSourceLookup(dataSourceLookup)
    }

    @Override
    protected Object determineCurrentLookupKey() {
        TenantContextHolder.getTenant()
    }

    void setDataSource(String tenant, DataSource dataSource) {
        dataSourceLookup.addDataSource(tenant, dataSource)
        Map<Object, Object> targetDataSources = new HashMap<>(dataSourceLookup.getDataSources())
        super.setTargetDataSources(targetDataSources)
        super.afterPropertiesSet()
    }
}
