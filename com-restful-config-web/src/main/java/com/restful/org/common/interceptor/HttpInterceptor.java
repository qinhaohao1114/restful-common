package com.restful.org.common.interceptor;

import com.restful.org.common.domain.HttpLocalThread;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http拦截器
 *
 * @author qinhaohao
 * @create 2017-12-28 15:56
 **/
public final class HttpInterceptor extends HandlerInterceptorAdapter{
    public HttpInterceptor() {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpLocalThread.clean();
        super.afterCompletion(request, response, handler, ex);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpLocalThread.set(request, response);
        return super.preHandle(request, response, handler);
    }
}
