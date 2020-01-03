package com.pims.service;

import com.pims.entity.Attract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
public interface AttractService{

    Object apply(Attract attract);

    List<Attract> getByUserIdAndProId(Long id, Long projectId);

    Attract getById(Long id);

    Object getAllByLimit(Attract attract);

    void delById(String id);

    void updateById(Attract attract);
}
