package com.sofency.top.nuxtblog.dto;

import com.sofency.top.nuxtblog.entity.Archive;
import lombok.*;

/**
 * <p>Project: nuxt-blog - ArchiveDTO
 * <p>Powered by echo On 2024-04-08 12:56:55
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
public class ArchiveDTO {
    private Archive archive;
    private int count;
}
