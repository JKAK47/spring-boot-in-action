package org.vincent.dao.impl;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.vincent.dao.model.BatchStepExecutionContext;
import org.vincent.dao.model.BatchStepExecutionContextExample;

public interface BatchStepExecutionContextMapper {
    @SelectProvider(type=BatchStepExecutionContextSqlProvider.class, method="countByExample")
    long countByExample(BatchStepExecutionContextExample example);

    @DeleteProvider(type=BatchStepExecutionContextSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchStepExecutionContextExample example);

    @Delete({
        "delete from BATCH_STEP_EXECUTION_CONTEXT",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long stepExecutionId);

    @Insert({
        "insert into BATCH_STEP_EXECUTION_CONTEXT (STEP_EXECUTION_ID, SHORT_CONTEXT, ",
        "SERIALIZED_CONTEXT)",
        "values (#{stepExecutionId,jdbcType=BIGINT}, #{shortContext,jdbcType=VARCHAR}, ",
        "#{serializedContext,jdbcType=LONGVARCHAR})"
    })
    int insert(BatchStepExecutionContext record);

    @InsertProvider(type=BatchStepExecutionContextSqlProvider.class, method="insertSelective")
    int insertSelective(BatchStepExecutionContext record);

    @SelectProvider(type=BatchStepExecutionContextSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BatchStepExecutionContext> selectByExampleWithBLOBsWithRowbounds(BatchStepExecutionContextExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchStepExecutionContextSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BatchStepExecutionContext> selectByExampleWithBLOBs(BatchStepExecutionContextExample example);

    @SelectProvider(type=BatchStepExecutionContextSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchStepExecutionContext> selectByExampleWithRowbounds(BatchStepExecutionContextExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchStepExecutionContextSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchStepExecutionContext> selectByExample(BatchStepExecutionContextExample example);

    @Select({
        "select",
        "STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT",
        "from BATCH_STEP_EXECUTION_CONTEXT",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    BatchStepExecutionContext selectByPrimaryKey(Long stepExecutionId);

    @UpdateProvider(type=BatchStepExecutionContextSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchStepExecutionContext record, @Param("example") BatchStepExecutionContextExample example);

    @UpdateProvider(type=BatchStepExecutionContextSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BatchStepExecutionContext record, @Param("example") BatchStepExecutionContextExample example);

    @UpdateProvider(type=BatchStepExecutionContextSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchStepExecutionContext record, @Param("example") BatchStepExecutionContextExample example);

    @UpdateProvider(type=BatchStepExecutionContextSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BatchStepExecutionContext record);

    @Update({
        "update BATCH_STEP_EXECUTION_CONTEXT",
        "set SHORT_CONTEXT = #{shortContext,jdbcType=VARCHAR},",
          "SERIALIZED_CONTEXT = #{serializedContext,jdbcType=LONGVARCHAR}",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(BatchStepExecutionContext record);

    @Update({
        "update BATCH_STEP_EXECUTION_CONTEXT",
        "set SHORT_CONTEXT = #{shortContext,jdbcType=VARCHAR}",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BatchStepExecutionContext record);
}