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
import org.vincent.dao.model.BatchJobExecutionContext;
import org.vincent.dao.model.BatchJobExecutionContextExample;

public interface BatchJobExecutionContextMapper {
    @SelectProvider(type=BatchJobExecutionContextSqlProvider.class, method="countByExample")
    long countByExample(BatchJobExecutionContextExample example);

    @DeleteProvider(type=BatchJobExecutionContextSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobExecutionContextExample example);

    @Delete({
        "delete from BATCH_JOB_EXECUTION_CONTEXT",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long jobExecutionId);

    @Insert({
        "insert into BATCH_JOB_EXECUTION_CONTEXT (JOB_EXECUTION_ID, SHORT_CONTEXT, ",
        "SERIALIZED_CONTEXT)",
        "values (#{jobExecutionId,jdbcType=BIGINT}, #{shortContext,jdbcType=VARCHAR}, ",
        "#{serializedContext,jdbcType=LONGVARCHAR})"
    })
    int insert(BatchJobExecutionContext record);

    @InsertProvider(type=BatchJobExecutionContextSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobExecutionContext record);

    @SelectProvider(type=BatchJobExecutionContextSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BatchJobExecutionContext> selectByExampleWithBLOBsWithRowbounds(BatchJobExecutionContextExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobExecutionContextSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BatchJobExecutionContext> selectByExampleWithBLOBs(BatchJobExecutionContextExample example);

    @SelectProvider(type=BatchJobExecutionContextSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobExecutionContext> selectByExampleWithRowbounds(BatchJobExecutionContextExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobExecutionContextSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobExecutionContext> selectByExample(BatchJobExecutionContextExample example);

    @Select({
        "select",
        "JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT",
        "from BATCH_JOB_EXECUTION_CONTEXT",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SHORT_CONTEXT", property="shortContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERIALIZED_CONTEXT", property="serializedContext", jdbcType=JdbcType.LONGVARCHAR)
    })
    BatchJobExecutionContext selectByPrimaryKey(Long jobExecutionId);

    @UpdateProvider(type=BatchJobExecutionContextSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobExecutionContext record, @Param("example") BatchJobExecutionContextExample example);

    @UpdateProvider(type=BatchJobExecutionContextSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BatchJobExecutionContext record, @Param("example") BatchJobExecutionContextExample example);

    @UpdateProvider(type=BatchJobExecutionContextSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobExecutionContext record, @Param("example") BatchJobExecutionContextExample example);

    @UpdateProvider(type=BatchJobExecutionContextSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BatchJobExecutionContext record);

    @Update({
        "update BATCH_JOB_EXECUTION_CONTEXT",
        "set SHORT_CONTEXT = #{shortContext,jdbcType=VARCHAR},",
          "SERIALIZED_CONTEXT = #{serializedContext,jdbcType=LONGVARCHAR}",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(BatchJobExecutionContext record);

    @Update({
        "update BATCH_JOB_EXECUTION_CONTEXT",
        "set SHORT_CONTEXT = #{shortContext,jdbcType=VARCHAR}",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BatchJobExecutionContext record);
}