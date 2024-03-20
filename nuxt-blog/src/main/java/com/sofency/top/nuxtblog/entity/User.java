package com.sofency.top.nuxtblog.entity;

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
import lombok.Builder;
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
@TableName("user")
@ApiModel(value = "User对象", description = "")
@Builder
@ToString
public class User extends Model<User> {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("用户网站")
    @TableField("website")
    private String website;

    @ApiModelProperty("注册时间")
    @TableField("register_time")
    private Date registerTime;


    public static final String ID = "id";

    public static final String NICKNAME = "nickname";

    public static final String EMAIL = "email";

    public static final String WEBSITE = "website";

    public static final String REGISTER_TIME = "register_time";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
