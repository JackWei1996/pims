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
public class Attract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 申请留言
     */
    private String message;

    /**
     * 项目状态：0未审核、1审核通过进行中、2正常关闭、9未通过
     */
    private String status;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;


}
