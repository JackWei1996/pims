package com.pims.service;

import com.pims.entity.Complaint;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
public interface ComplaintService{

    Object getAllComplaintByLimit(Complaint complaint);

    void delById(String id);

    void save(Complaint complaint);

    void updateById(Complaint complaint);
}
