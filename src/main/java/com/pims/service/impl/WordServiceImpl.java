package com.pims.service.impl;

import com.pims.entity.Word;
import com.pims.mapper.WordMapper;
import com.pims.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
