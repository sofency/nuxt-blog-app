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
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@TableName("comment")
@ApiModel(value = "Comment对象", description = "")
@ToString
public class Comment extends Model<Comment> {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户的id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("博客ID")
    @TableField("blog_id")
    private Integer blogId;

    @ApiModelProperty("评论的内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("父评论id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("回复评论id")
    @TableField("reply_user_id")
    private Integer replyUserId;

    @ApiModelProperty("是否删除 0否 1是")
    @TableField("is_delete")
    private Boolean deleted;

    @ApiModelProperty("是否审核过 0未审核，1审核过，审核过定时发送给回复的用户")
    @TableField("is_review")
    private Boolean review;

    @ApiModelProperty("是否发送过 0未发送 1发送")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("评论时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String BLOG_ID = "blog_id";

    public static final String CONTENT = "content";

    public static final String PARENT_ID = "parent_id";

    public static final String REPLY_USER_ID = "reply_user_id";

    public static final String IS_DELETE = "is_delete";

    public static final String IS_REVIEW = "is_review";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
