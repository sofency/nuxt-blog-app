package com.sofency.top.nuxtblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.dto.ArchiveDTO;
import com.sofency.top.nuxtblog.service.ArchiveService;
import com.sofency.top.nuxtblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sofency.top.nuxtblog.mapper.ArchiveMapper;
import com.sofency.top.nuxtblog.entity.Archive;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sofency
 * @since 2024-04-07
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper, Archive> implements ArchiveService {

}
