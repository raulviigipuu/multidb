package ee.viigipuu.multidb.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

class DataSourceRouting extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String tenant = TenantContextHolder.getTenant()
        if (tenant == null) {
            throw new IllegalStateException("Tenant not set")
        }
        return tenant
    }
}
