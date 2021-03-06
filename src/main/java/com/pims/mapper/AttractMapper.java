package com.pims.mapper;

import com.pims.entity.Attract;
import com.pims.entity.AttractExample;
import java.util.List;

import com.pims.entity.Word;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    long countByExample(AttractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int deleteByExample(AttractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int insert(Attract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int insertSelective(Attract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    List<Attract> selectByExample(AttractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    Attract selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") Attract record, @Param("example") AttractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByExample(@Param("record") Attract record, @Param("example") AttractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByPrimaryKeySelective(Attract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attract
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByPrimaryKey(Attract record);

    List<Word> getAllByLimit(Attract attract);

    int countAllByLimit(Attract attract);
}