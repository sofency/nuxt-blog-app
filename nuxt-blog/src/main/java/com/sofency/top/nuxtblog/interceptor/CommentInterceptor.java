package com.sofency.top.nuxtblog.interceptor;

import com.sofency.top.nuxtblog.exception.SessionTimeoutException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p>Project: nuxt-blog - CommentInterceptor
 * <p>Powered by echo On 2024-03-16 20:53:33
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 * 评论拦截器
 */
public class CommentInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (StringUtils.isEmpty(user)) {
            throw new SessionTimeoutException("session过期,请再次输入身份信息");
        }
        return true;
    }
}
