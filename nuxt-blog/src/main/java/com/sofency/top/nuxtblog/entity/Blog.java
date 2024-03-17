package com.sofency.top.nuxtblog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sofency
 * @since 2024-03-16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("blog")
@ApiModel(value = "Blog对象", description = "")
public class Blog extends Model<Blog> {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("标签")
    @TableField("tag")
    private String tag;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("是否置顶 0否 1是")
    @TableField("is_top")
    private Boolean top;

    @ApiModelProperty("是否删除 0 1是")
    @TableField("is_delete")
    private Boolean delete;

    @ApiModelProperty("状态值 1公开 2私密 3评论可见")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("发表时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String TAG = "tag";

    public static final String CONTENT = "content";

    public static final String IS_TOP = "is_top";

    public static final String IS_DELETE = "is_delete";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
