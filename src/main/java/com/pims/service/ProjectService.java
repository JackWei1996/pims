package com.pims.service;

import com.pims.entity.Company;
import com.pims.entity.Project;
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
public interface ProjectService {

    Project getById(Long id);

    Object getAllByLimit(Project project);

    void delById(String id);

    void updateById(Project project);

    void save(Project project);

    void view(Long id);

    Object getApplyList(Project project);

    void apply(Long projectId);

}
