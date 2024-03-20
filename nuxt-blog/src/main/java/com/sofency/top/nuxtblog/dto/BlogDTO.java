package com.sofency.top.nuxtblog.dto;

import com.sofency.top.nuxtblog.entity.Blog;
import lombok.*;
import java.util.List;
/**
 * <p>Project: nuxt-blog - BlogDTO
 * <p>Powered by echo On 2024-03-17 20:52:10
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
public class BlogDTO {
    private Blog blog;
    private List<CommentDTO> comments;
}