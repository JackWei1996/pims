package com.pims.service;

import com.pims.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
public interface CompanyService{

    Object getAllCompanyByLimit(Company company);

    void delById(String id);

    void  save(Company company);

    void updateById(Company company);

    Company getById(Long id);
}
