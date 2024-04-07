package com.sofency.top.nuxtblog.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

/**
 * <p>Project: nuxt-blog - MybatisGeneratorUtils
 * <p>Powered by echo On 2024-03-16 18:16:12
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
public class MybatisGeneratorUtils {
    /**
     * 代码生成
     */
    public void generate() {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/nuxt-blog?useSSL=false",
                        "root",
                        "iOEfoW@1eW0")

                // 全局配置
                .globalConfig(builder -> {
                    builder
                            .enableSwagger() // 是否启用swagger注解
                            .author("sofency") // 作者名称
                            .dateType(DateType.ONLY_DATE) // 时间策略
                            .commentDate("yyyy-MM-dd") // 注释日期
                            .outputDir("/Users/sofency/code/nuxt-blog/src/main/java") // 输出目录
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir(); // 生成后禁止打开所生成的系统目录
                })

                // 包配置
                .packageConfig(builder -> {
                    builder
                            .parent("com.sofency.top") // 父包名
                            .moduleName("nuxtblog") // 模块包名
                            .entity("entity") // 实体类包名
                            .service("service") // service包名
                            .serviceImpl("service.impl") // serviceImpl包名
                            .mapper("mapper") // mapper包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/sofency/code/nuxt-blog/src/main/resources/mapper")) // xml位置（还可自定义配置entity，service等位置）
                            .controller("controller"); // controller包名
                })

                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() // 开启lombok
                            .enableChainModel() // 链式
                            .enableRemoveIsPrefix() // 开启boolean类型字段移除is前缀
                            .enableTableFieldAnnotation() //开启生成实体时生成的字段注解
                            .versionColumnName("version") // 乐观锁数据库字段
                            .versionPropertyName("version") // 乐观锁实体类名称
                            .logicDeleteColumnName("is_deleted") // 逻辑删除数据库中字段名
                            .logicDeletePropertyName("deleted") // 逻辑删除实体类中的字段名
                            .naming(NamingStrategy.underline_to_camel) // 表名 下划线 -》 驼峰命名
                            .columnNaming(NamingStrategy.underline_to_camel) // 字段名 下划线 -》 驼峰命名
                            .idType(IdType.ASSIGN_ID) // 主键生成策略 雪花算法生成id
                            .formatFileName("%s") // Entity 文件名称
                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 表字段填充
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE)) // 表字段填充
                            .enableColumnConstant()
                            .enableActiveRecord()

                            // Controller 策略配置
                            .controllerBuilder()
                            .enableRestStyle() // 开启@RestController
                            .formatFileName("%sController") // Controller 文件名称

                            // Service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") // Service 文件名称
                            .formatServiceImplFileName("%sServiceImpl") // ServiceImpl 文件名称

                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableMapperAnnotation() // 开启@Mapper
                            .enableBaseColumnList() // 启用 columnList (通用查询结果列)
                            .enableBaseResultMap() // 启动resultMap
                            .formatMapperFileName("%sMapper") // Mapper 文件名称
                            .formatXmlFileName("%sMapper"); // Xml 文件名称
                })
                .execute(); // 执行
    }
}
