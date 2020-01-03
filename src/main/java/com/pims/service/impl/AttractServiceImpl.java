package com.pims.service.impl;

import com.pims.entity.Attract;
import com.pims.entity.AttractExample;
import com.pims.entity.ProjectExample;
import com.pims.entity.Word;
import com.pims.mapper.AttractMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.AttractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AttractServiceImpl implements AttractService {
    @Autowired
    private AttractMapper attractMapper;

    @Override
    public Object apply(Attract attract) {
        return attractMapper.insert(attract);
    }

    @Override
    public List<Attract> getByUserIdAndProId(Long id, Long projectId) {
        AttractExample example = new AttractExample();
        example.createCriteria().andUserIdEqualTo(id).andProjectIdEqualTo(projectId);
        return attractMapper.selectByExample(example);
    }

    @Override
    public Attract getById(Long id) {
        return attractMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object getAllByLimit(Attract attract) {
        int size = 0;

        Integer begin = (attract.getPage() - 1) * attract.getLimit();
        attract.setPage(begin);

        List<Word> rows = new ArrayList<>();
        try {
            rows = attractMapper.getAllByLimit(attract);
            size = attractMapper.countAllByLimit(attract);
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
        attractMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void updateById(Attract attract) {
        AttractExample example = new AttractExample();
        example.createCriteria().andIdEqualTo(attract.getId());
        attractMapper.updateByExampleSelective(attract, example);
    }
}
