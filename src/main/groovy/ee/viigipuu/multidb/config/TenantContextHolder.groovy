package ee.viigipuu.multidb.config

import org.springframework.stereotype.Component

@Component
class TenantContextHolder {

    private static final ThreadLocal<String> tenantHolder = new ThreadLocal<>()

    static void setTenant(String tenant) {
        tenantHolder.set(tenant)
    }

    static String getTenant() {
        tenantHolder.get()
    }

    static void clear() {
        tenantHolder.remove()
    }
}
