package com.restful.org.common.controller;


import com.alibaba.fastjson.JSON;
import com.restful.org.common.call_back.ActionCallback;
import com.restful.org.common.domain.HttpLocalThread;
import com.restful.org.common.domain.PageView;
import com.restful.org.common.domain.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * baseController拦截请求
 *
 * @author qinhaohao
 * @create 2017-12-28 16:03
 **/
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public BaseController() {
    }

    protected Object execute(ActionCallback callback) {
        HttpServletRequest request = HttpLocalThread.getRequest();
        ResultMessage message = new ResultMessage();
        Map<String, String[]> requestParams = request.getParameterMap();
        String uri = request.getRequestURI();
        LOGGER.info("<<<request uri:{},params:{}", uri, JSON.toJSONString(requestParams));
        message.setAction(request.getMethod());
        message.setUrl(uri);
        message.setTimestamp(System.currentTimeMillis());
        Object content = callback.execute();
        message.setDuration(System.currentTimeMillis() - message.getTimestamp());
        message.setStatus(0);
        if (content != null) {
            if (content instanceof PageView) {
                message.setData(content);
            } else if (ClassUtils.isPrimitiveWrapper(content.getClass())) {
                message.setData(Collections.singletonMap("result", content));
            } else {
                message.setData(content);
            }
        }
        return message;
    }
}
