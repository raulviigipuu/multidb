package ee.viigipuu.multidb.config

import org.apache.ibatis.mapping.MappedStatement
import org.apache.ibatis.plugin.Invocation

class TenantDataSourceInterceptor implements Interceptor {

    Object intercept(Invocation invocation) throws Throwable {
        def mappedStatement = invocation.getArgs()[0] as MappedStatement
        def parameters = invocation.getArgs()[1]
        def tenantId = TenantContextHolder.getTenantId()
        if (tenantId != null) {
            DataSourceContextHolder.setDataSourceType(tenantId)
        }
        def result = invocation.proceed()
        DataSourceContextHolder.clearDataSourceType()
        return result
    }

    void setProperties(Properties properties) {
        // No properties needed
    }

    void plugin(Object target) {
        Plugin.wrap(target, this)
    }


    @Override
    Object beforeInvoke(Object object, String methodName, Object[] arguments) {
        return null
    }

    @Override
    Object afterInvoke(Object object, String methodName, Object[] arguments, Object result) {
        return null
    }

    @Override
    boolean doInvoke() {
        return false
    }
}
