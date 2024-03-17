package com.sofency.top.nuxtblog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>Project: nuxt-blog - JsonUtils
 * <p>Powered by echo On 2024-03-16 20:38:42
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 8
 */
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将Java对象转换为JSON字符串
     *
     * @param obj 要转换的Java对象
     * @return 转换后的JSON字符串
     * @throws JsonProcessingException 如果转换过程中发生错误
     */
    public static String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * 将JSON字符串转换为Java对象
     *
     * @param json JSON字符串
     * @param clazz 要转换的目标类的Class对象
     * @param <T> 目标类的类型参数
     * @return 转换后的Java对象
     * @throws JsonProcessingException 如果转换过程中发生错误
     */
    public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }
}
