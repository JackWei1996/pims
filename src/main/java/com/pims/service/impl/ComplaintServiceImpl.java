package com.pims.service.impl;

import com.pims.entity.Complaint;
import com.pims.entity.Complaint;
import com.pims.entity.ComplaintExample;
import com.pims.entity.Word;
import com.pims.mapper.ComplaintMapper;
import com.pims.mapper.ComplaintMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.ComplaintService;
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
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public void save(Complaint complaint) {
        complaintMapper.insert(complaint);
    }

    @Override
    public void updateById(Complaint complaint) {
        ComplaintExample example = new ComplaintExample();
        example.createCriteria().andIdEqualTo(complaint.getId());
        complaintMapper.updateByExampleSelective(complaint, example);
    }

    @Override
    public Complaint getById(Long id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    @Override
    public Object getAllComplaintByLimit(Complaint complaint) {
        int size = 0;

        Integer begin = (complaint.getPage() - 1) * complaint.getLimit();
        complaint.setPage(begin);

        List<Word> rows = new ArrayList<>();
        try {
            rows = complaintMapper.getAllComplaintByLimit(complaint);
            size = complaintMapper.countAllComplaintByLimit(complaint);
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
        complaintMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
