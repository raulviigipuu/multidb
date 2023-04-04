package ee.viigipuu.multidb.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class TenantInterceptor implements HandlerInterceptor {

    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI().substring(request.getContextPath().length())
        String[] parts = path.split("/")

        if (parts.size() >= 2) {
            String tenantId = parts[1]
            TenantContextHolder.setTenantId(tenantId)
            return true
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing tenant ID in request path")
            return false
        }
    }

    @Override
    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TenantContextHolder.clear()
    }
}
