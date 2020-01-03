package com.pims.service;

import com.pims.entity.Project;
import com.pims.entity.Word;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 园区招商管理系统
 * @since 2019-12-30
 */
public interface WordService{

    Word getById(Long id);

    void save(Word word);

    Object getAllWordByLimit(Word word);

    void delById(String id);

    void view(Long id);
}
