package org.vincent.dao.impl;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.vincent.dao.model.BatchJobExecutionParams;
import org.vincent.dao.model.BatchJobExecutionParamsExample;

public interface BatchJobExecutionParamsMapper {
    @SelectProvider(type=BatchJobExecutionParamsSqlProvider.class, method="countByExample")
    long countByExample(BatchJobExecutionParamsExample example);

    @DeleteProvider(type=BatchJobExecutionParamsSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobExecutionParamsExample example);

    @Insert({
        "insert into BATCH_JOB_EXECUTION_PARAMS (JOB_EXECUTION_ID, TYPE_CD, ",
        "KEY_NAME, STRING_VAL, ",
        "DATE_VAL, LONG_VAL, ",
        "DOUBLE_VAL, IDENTIFYING)",
        "values (#{jobExecutionId,jdbcType=BIGINT}, #{typeCd,jdbcType=VARCHAR}, ",
        "#{keyName,jdbcType=VARCHAR}, #{stringVal,jdbcType=VARCHAR}, ",
        "#{dateVal,jdbcType=TIMESTAMP}, #{longVal,jdbcType=BIGINT}, ",
        "#{doubleVal,jdbcType=DOUBLE}, #{identifying,jdbcType=CHAR})"
    })
    int insert(BatchJobExecutionParams record);

    @InsertProvider(type=BatchJobExecutionParamsSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobExecutionParams record);

    @SelectProvider(type=BatchJobExecutionParamsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT),
        @Result(column="TYPE_CD", property="typeCd", jdbcType=JdbcType.VARCHAR),
        @Result(column="KEY_NAME", property="keyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="STRING_VAL", property="stringVal", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATE_VAL", property="dateVal", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LONG_VAL", property="longVal", jdbcType=JdbcType.BIGINT),
        @Result(column="DOUBLE_VAL", property="doubleVal", jdbcType=JdbcType.DOUBLE),
        @Result(column="IDENTIFYING", property="identifying", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobExecutionParams> selectByExampleWithRowbounds(BatchJobExecutionParamsExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobExecutionParamsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT),
        @Result(column="TYPE_CD", property="typeCd", jdbcType=JdbcType.VARCHAR),
        @Result(column="KEY_NAME", property="keyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="STRING_VAL", property="stringVal", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATE_VAL", property="dateVal", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LONG_VAL", property="longVal", jdbcType=JdbcType.BIGINT),
        @Result(column="DOUBLE_VAL", property="doubleVal", jdbcType=JdbcType.DOUBLE),
        @Result(column="IDENTIFYING", property="identifying", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobExecutionParams> selectByExample(BatchJobExecutionParamsExample example);

    @UpdateProvider(type=BatchJobExecutionParamsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobExecutionParams record, @Param("example") BatchJobExecutionParamsExample example);

    @UpdateProvider(type=BatchJobExecutionParamsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobExecutionParams record, @Param("example") BatchJobExecutionParamsExample example);
}