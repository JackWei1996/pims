package com.pims.service.impl;

import com.pims.entity.Company;
import com.pims.entity.CompanyExample;
import com.pims.entity.Word;
import com.pims.mapper.CompanyMapper;
import com.pims.mapper.WordMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void save(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public void updateById(Company company) {
        CompanyExample example = new CompanyExample();
        example.createCriteria().andIdEqualTo(company.getId());
        companyMapper.updateByExampleSelective(company, example);
    }

    @Override
    public Object getAllCompanyByLimit(Company company) {
        int size = 0;

        Integer begin = (company.getPage() - 1) * company.getLimit();
        company.setPage(begin);

        List<Word> rows = new ArrayList<>();
        try {
            rows = companyMapper.getAllCompanyByLimit(company);
            size = companyMapper.countAllCompanyByLimit(company);
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
        companyMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
