package ee.viigipuu.multidb.config

import ee.viigipuu.multidb.types.DataSourceType
import org.springframework.stereotype.Service

@Service
class DataSourceRoutingService {

    void setDataSourceType(DataSourceType dataSourceType) {
        DataSourceContextHolder.setDataSourceType(dataSourceType)
    }

    void clearDataSourceType() {
        DataSourceContextHolder.clearDataSourceType()
    }
}
