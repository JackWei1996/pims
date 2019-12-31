package com.pims.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态：0未处理、1已处理
     */
    private Integer status;

    /**
     * 处理信息
     */
    private String processMsg;

    /**
     * 类型：1投诉、2是司法求助
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
