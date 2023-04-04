package ee.viigipuu.multidb.config

import ee.viigipuu.multidb.types.DataSourceType

class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>()

    static void setDataSourceType(DataSourceType dataSourceType) {
        contextHolder.set(dataSourceType)
    }

    static DataSourceType getDataSourceType() {
        return contextHolder.get()
    }

    static void clearDataSourceType() {
        contextHolder.remove()
    }
}
