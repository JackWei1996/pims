package com.pims.service.impl;

import com.pims.entity.Contract;
import com.pims.entity.Word;
import com.pims.mapper.ContractMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.ContractService;
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
public class ContractServiceImpl  implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public Contract getById(Long id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Contract contract) {
        contractMapper.insert(contract);
    }

    @Override
    public Object getAllByLimit(Contract contract) {
        int size = 0;

        Integer begin = (contract.getPage() - 1) * contract.getLimit();
        contract.setPage(begin);

        List<Contract> rows = new ArrayList<>();
        try {
            rows = contractMapper.getAllByLimit(contract);
            size = contractMapper.countAllByLimit(contract);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MMGridPageVoBean<Contract> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void delById(String id) {
        contractMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
