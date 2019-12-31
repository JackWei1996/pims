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
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 详情
     */
    private String content;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 项目状态：0未审核、1审核通过进行中、2正常关闭、9未通过
     */
    private String status;

    /**
     * 项目开始时间
     */
    private Date startTime;

    /**
     * 项目结束时间
     */
    private Date endTime;

    /**
     * 查看次数
     */
    private Integer viewCount;

    /**
     * 报名次数
     */
    private Integer applyCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
