package ee.viigipuu.multidb.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig implements WebMvcConfigurer {

    private final TenantInterceptor tenantInterceptor

    WebConfig(TenantInterceptor tenantInterceptor) {
        this.tenantInterceptor = tenantInterceptor
    }

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantInterceptor)
    }
}