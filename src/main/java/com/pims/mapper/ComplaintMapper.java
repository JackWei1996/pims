package com.pims.mapper;

import com.pims.entity.Complaint;
import com.pims.entity.ComplaintExample;
import java.util.List;

import com.pims.entity.Word;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    long countByExample(ComplaintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int deleteByExample(ComplaintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int insert(Complaint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int insertSelective(Complaint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    List<Complaint> selectByExample(ComplaintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    Complaint selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByPrimaryKeySelective(Complaint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table complaint
     *
     * @mbg.generated Tue Dec 31 16:11:46 CST 2019
     */
    int updateByPrimaryKey(Complaint record);

    List<Word> getAllComplaintByLimit(Complaint complaint);

    int countAllComplaintByLimit(Complaint complaint);
}