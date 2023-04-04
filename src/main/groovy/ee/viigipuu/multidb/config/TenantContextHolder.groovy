package ee.viigipuu.multidb.config

class TenantContextHolder {
    static ThreadLocal<String> tenantId = new ThreadLocal<String>()

    static String getTenantId() {
        return tenantId.get()
    }

    static void setTenantId(String id) {
        tenantId.set(id)
    }

    static void clear() {
        tenantId.remove()
    }
}
