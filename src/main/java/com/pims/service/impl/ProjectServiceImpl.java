package com.pims.service.impl;


import com.pims.entity.*;
import com.pims.mapper.ProjectMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Project getById(Long id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object getAllByLimit(Project project) {
        int size = 0;

        Integer begin = (project.getPage() - 1) * project.getLimit();
        project.setPage(begin);

        List<Word> rows = new ArrayList<>();
        try {
            rows = projectMapper.getAllByLimit(project);
            size = projectMapper.countAllByLimit(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MMGridPageVoBean<Word> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void delById(String id) {
        projectMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void updateById(Project project) {
        ProjectExample example = new ProjectExample();
        example.createCriteria().andIdEqualTo(project.getId());
        projectMapper.updateByExampleSelective(project, example);
    }

    @Override
    public void save(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public void view(Long id) {
        projectMapper.view(id);
    }

    @Override
    public Object getApplyList(Project project) {
        project.setStatus(1+"");
        return getAllByLimit(project);
    }

    @Override
    public void apply(Long projectId) {
        projectMapper.apply(projectId);
    }
}
