package com.pims.service;

import com.pims.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
public interface ContractService{

    Contract getById(Long id);

    void save(Contract contract);

    Object getAllByLimit(Contract contract);

    void delById(String id);
}
