package com.jack.doormis.common.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.doormis.core.authority.CheckAuthorityResultEnum;
import com.jack.doormis.core.authority.bo.AuthorityBo;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.interfaces.http.CommonController;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Created by Jack on 2017/2/26.
 */

public class CommonInterceptor extends HandlerInterceptorAdapter {
    protected Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private AuthorityBo authorityBo;

	/*
     * 利用正则映射到需要拦截的路径

    private String mappingURL;

    public void setMappingURL(String mappingURL) {
               this.mappingURL = mappingURL;
    }
  */

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * <p>
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        log.info("requestUri:" + requestUri);
        log.info("contextPath:" + contextPath);
        log.info("url:" + url);

        User userInfo = (User) request.getSession().getAttribute(CommonKeys.SESSION_USER);

        boolean rtn = false;
        CheckAuthorityResultEnum result = authorityBo.checkAuthority(userInfo, url);
        switch (result) {
            case RETURN_TRUE:
                rtn = true;
                break;
            case NEED_LOGIN:
                request.getRequestDispatcher(CommonController.URL_GOTO_LOGIN_PAGE).forward(request, response);
                rtn = false;
                break;
            case NO_AUTHORITY:
                request.getRequestDispatcher("/error/no_access.html").forward(request, response);
                rtn = false;
                break;
        }

        return rtn;
    }
}
