package com.futao.shardingspherelearn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author futao
 * @since 2022/11/18
 */
@TableName("t_user")
@Data
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String uname;
}
