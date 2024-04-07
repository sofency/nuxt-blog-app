package com.sofency.top.nuxtblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofency.top.nuxtblog.entity.Tag;
import com.sofency.top.nuxtblog.mapper.TagMapper;
import com.sofency.top.nuxtblog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sofency
 * @since 2024-04-07
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
