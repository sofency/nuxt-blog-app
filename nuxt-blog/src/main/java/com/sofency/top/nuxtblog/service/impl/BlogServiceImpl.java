package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sofency.top.nuxtblog.dto.ArchiveDTO;
import com.sofency.top.nuxtblog.dto.BlogDTO;
import com.sofency.top.nuxtblog.dto.BlogDetail;
import com.sofency.top.nuxtblog.dto.CommentListDTO;
import com.sofency.top.nuxtblog.entity.Archive;
import com.sofency.top.nuxtblog.entity.Blog;
import com.sofency.top.nuxtblog.entity.Tag;
import com.sofency.top.nuxtblog.exception.ErrorBlogIdException;
import com.sofency.top.nuxtblog.mapper.BlogMapper;
import com.sofency.top.nuxtblog.service.ArchiveService;
import com.sofency.top.nuxtblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.service.CommentService;
import com.sofency.top.nuxtblog.service.TagService;
import com.sofency.top.nuxtblog.vo.PageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    /**
     * 每页显示10条
     */
    private static final int SIZE = 5;
    private final CommentService commentService;
    private final TagService tagService;
    private final ArchiveService archiveService;

    @Autowired
    public BlogServiceImpl(CommentService commentService, TagService tagService, ArchiveService archiveService) {
        this.commentService = commentService;
        this.tagService = tagService;
        this.archiveService = archiveService;
    }

    private BlogDetail changeToBlogDetail(Blog blog) {
        BlogDetail blogDetail = BlogDetail.fromBlog(blog);
        String tag = blog.getTag();
        if (!StringUtils.isEmpty(tag)) {
            List<Integer> tagIds = Arrays.stream(tag.split(";")).map(Integer::parseInt).toList();
            List<String> tags = tagService.listByIds(tagIds).stream().map(Tag::getName).collect(Collectors.toList());
            blogDetail.setTagList(StringUtils.join(tags, ','));
        }
        Archive archive = archiveService.getById(blogDetail.getArchiveId());
        blogDetail.setArchiveName(archive.getName());
        return blogDetail;
    }

    @Override
    public BlogDTO getBlogInfoByBlogId(Integer blogId) {
        Blog blog = this.getById(blogId);
        if (Objects.isNull(blog)) {
            throw new ErrorBlogIdException("未找到该文件,请检查BlogId");
        }
        BlogDetail blogDetail = changeToBlogDetail(blog);
        List<CommentListDTO> commentListDTOS = commentService.getCommentByBlogId(blogId);
        return BlogDTO.builder().comments(commentListDTOS).blog(blogDetail).build();
    }

    @Override
    public PageVO pageList(Long current) {
        IPage<Blog> blogIPage = new Page<>(current, SIZE);
        IPage<Blog> pageList = this.page(blogIPage);
        List<BlogDetail> results = pageList.getRecords().stream().map(this::changeToBlogDetail).toList();
        return PageVO.builder().total(pageList.getTotal()).current(pageList.getCurrent())
                .page(SIZE)
                .results(results).build();
    }

    @Override
    public PageVO pageList(Long current, QueryWrapper<Blog> wrapper) {
        IPage<Blog> blogIPage = new Page<>(current, SIZE);
        IPage<Blog> pageList = this.page(blogIPage, wrapper);
        List<Blog> results = pageList.getRecords();
        return PageVO.builder().total(pageList.getTotal()).current(pageList.getCurrent())
                .page(SIZE)
                .results(results).build();
    }

    @Override
    public List<ArchiveDTO> buildArchives() {
        List<Archive> archives = archiveService.list();
        return archives.stream().map(archive -> {
            QueryWrapper<Blog> wrapper = new QueryWrapper<>();
            wrapper.eq(Blog.ARCHIVE_ID, archive.getId());
            List<Blog> blogList = this.list(wrapper);
            return ArchiveDTO.builder().archive(archive).count(blogList.size()).build();
        }).collect(Collectors.toList());
    }
}
