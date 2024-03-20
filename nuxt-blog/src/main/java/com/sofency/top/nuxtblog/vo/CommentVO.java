package com.sofency.top.nuxtblog.vo;

import com.sofency.top.nuxtblog.entity.Comment;
import com.sofency.top.nuxtblog.entity.User;
import lombok.*;

/**
 * <p>Project: nuxt-blog - CommentVO
 * <p>Powered by echo On 2024-03-20 17:05:50
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
public class CommentVO {
    private Comment comment;
    private User user;
}
