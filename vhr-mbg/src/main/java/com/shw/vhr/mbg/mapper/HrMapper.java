package com.shw.vhr.mbg.mapper;

import com.shw.vhr.mbg.model.Hr;
import com.shw.vhr.mbg.model.HrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrMapper {
    long countByExample(HrExample example);

    int deleteByExample(HrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    List<Hr> selectByExample(HrExample example);

    Hr selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") Hr record, @Param("example") HrExample example);

    int updateByExample(@Param("record") Hr record, @Param("example") HrExample example);

    /**
     * 会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Hr record);

    /**
     * 对你注入的字段全部更新，将为空的字段在数据库中置为NULL
     * @param record
     * @return
     */
    int updateByPrimaryKey(Hr record);
}