package com.sofency.top.nuxtblog.vo;

import lombok.*;

import java.util.List;

/**
 * <p>Project: nuxt-blog - PageVO
 * <p>Powered by echo On 2024-04-07 17:56:51
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageVO  {
    private List<?> results;

    private long current;

    private long total;

    private long page;
}
