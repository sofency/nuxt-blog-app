package com.sofency.top.nuxtblog.dto;

import com.sofency.top.nuxtblog.entity.Comment;
import lombok.*;

import java.util.List;

/**
 * <p>Project: nuxt-blog - CommentDTO
 * <p>Powered by echo On 2024-03-17 12:07:13
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
public class CommentListDTO {
    private CommentDTO parentComment;
    private List<CommentDTO> childComment;
}
