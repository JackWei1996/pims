package com.pims.service.impl;

import com.pims.entity.User;
import com.pims.entity.Word;
import com.pims.mapper.WordMapper;
import com.pims.model.MMGridPageVoBean;
import com.pims.service.WordService;
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
public class WordServiceImpl implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public void save(Word word) {
        wordMapper.insert(word);
    }

    @Override
    public Object getAllWordByLimit(Word word) {
        int size = 0;

        Integer begin = (word.getPage() - 1) * word.getLimit();
        word.setPage(begin);

        List<Word> rows = new ArrayList<>();
        try {
            rows = wordMapper.getAllWordByLimit(word);
            size = wordMapper.countAllWordByLimit(word);
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
        wordMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
