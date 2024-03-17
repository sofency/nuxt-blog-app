package com.sofency.top.nuxtblog;

import com.sofency.top.nuxtblog.utils.MybatisGeneratorUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NuxtBlogApplicationTests {

    @Test
    void contextLoads() {
        var generator = new MybatisGeneratorUtils();
        generator.generate();
    }

}
