package com.sofency.top.nuxtblog.dto;

import com.sofency.top.nuxtblog.entity.Comment;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>Project: nuxt-blog - CommentVO
 * <p>Powered by echo On 2024-03-21 20:36:46
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO extends Comment {
    private String username;
    private String parentName;
    private String replyName;

    public CommentDTO(Comment comment) {
        this.setId(comment.getId());
        this.setUserId(comment.getUserId());
        this.setContent(comment.getContent());
        this.setCreateTime(comment.getCreateTime());
        this.setBlogId(comment.getBlogId());
        this.setDeleted(comment.getDeleted());
        this.setIpAddress(comment.getIpAddress());
        this.setIpSource(comment.getIpSource());
        this.setParentId(comment.getParentId());
        this.setReplyUserId(comment.getReplyUserId());
        this.setReview(comment.getReview());
        this.setStatus(comment.getStatus());
        this.setUpdateTime(comment.getUpdateTime());
        this.setDeleted(comment.getDeleted());
    }
}
