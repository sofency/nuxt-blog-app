package com.sofency.top.nuxtblog.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * <p>Project: nuxt-blog - SessionTimeoutException
 * <p>Powered by echo On 2024-03-16 21:01:13
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Getter
public class SessionTimeoutException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String errorMessage; // 自定义错误信息

    public SessionTimeoutException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}
