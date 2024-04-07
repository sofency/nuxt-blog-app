package com.sofency.top.nuxtblog.dto;

import com.sofency.top.nuxtblog.entity.Blog;
import lombok.*;

import java.util.List;

/**
 * <p>Project: nuxt-blog - BlogDetail
 * <p>Powered by echo On 2024-04-07 16:34:31
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
public class BlogDetail extends Blog {
    private String tagList;
    private String archiveName;

    public static BlogDetail fromBlog(Blog blog) {
        BlogDetail blogDetail = new BlogDetail();
        blogDetail.setId(blog.getId());
        blogDetail.setArchiveId(blog.getArchiveId());
        blogDetail.setTag(blog.getTag());
        blogDetail.setContent(blog.getContent());
        blogDetail.setTop(blog.getTop());
        blogDetail.setTitle(blog.getTitle());
        blogDetail.setUpdateTime(blog.getUpdateTime());
        blogDetail.setCreateTime(blog.getCreateTime());
        return blogDetail;
    }
}
