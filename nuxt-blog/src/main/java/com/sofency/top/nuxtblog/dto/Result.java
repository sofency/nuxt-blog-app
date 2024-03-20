package com.sofency.top.nuxtblog.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * <p>Project: nuxt-blog - Response
 * <p>Powered by echo On 2024-03-16 19:49:10
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int status;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> Result<T> error(int status, String message) {
        return new Result<>(status, message, null);
    }
}
