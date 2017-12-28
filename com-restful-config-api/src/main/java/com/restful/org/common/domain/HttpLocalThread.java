package com.restful.org.common.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将http请求放到threadLocal中
 *
 * @author qinhaohao
 * @create 2017-12-28 16:00
 **/
public class HttpLocalThread {
    static ThreadLocal<HttpLocalThread.HttpContext> threadLocal = new ThreadLocal();

    public HttpLocalThread() {
    }

    public static void set(HttpServletRequest req, HttpServletResponse res) {
        threadLocal.set(new HttpLocalThread.HttpContext(req, res));
    }

    public static HttpServletRequest getRequest() {
        return ((HttpLocalThread.HttpContext)threadLocal.get()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((HttpLocalThread.HttpContext)threadLocal.get()).getResponse();
    }

    public static void clean() {
        threadLocal.remove();
    }

    static class HttpContext {
        private HttpServletRequest request;
        private HttpServletResponse response;

        public HttpContext(HttpServletRequest request, HttpServletResponse response) {
            this.request = request;
            this.response = response;
        }

        public HttpServletRequest getRequest() {
            return this.request;
        }

        public HttpServletResponse getResponse() {
            return this.response;
        }
    }
}
