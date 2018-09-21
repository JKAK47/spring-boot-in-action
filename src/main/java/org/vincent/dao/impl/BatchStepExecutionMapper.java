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
import org.vincent.dao.model.BatchStepExecution;
import org.vincent.dao.model.BatchStepExecutionExample;

public interface BatchStepExecutionMapper {
    @SelectProvider(type=BatchStepExecutionSqlProvider.class, method="countByExample")
    long countByExample(BatchStepExecutionExample example);

    @DeleteProvider(type=BatchStepExecutionSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchStepExecutionExample example);

    @Delete({
        "delete from BATCH_STEP_EXECUTION",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long stepExecutionId);

    @Insert({
        "insert into BATCH_STEP_EXECUTION (STEP_EXECUTION_ID, VERSION, ",
        "STEP_NAME, JOB_EXECUTION_ID, ",
        "START_TIME, END_TIME, ",
        "STATUS, COMMIT_COUNT, ",
        "READ_COUNT, FILTER_COUNT, ",
        "WRITE_COUNT, READ_SKIP_COUNT, ",
        "WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ",
        "ROLLBACK_COUNT, EXIT_CODE, ",
        "EXIT_MESSAGE, LAST_UPDATED)",
        "values (#{stepExecutionId,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{stepName,jdbcType=VARCHAR}, #{jobExecutionId,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=VARCHAR}, #{commitCount,jdbcType=BIGINT}, ",
        "#{readCount,jdbcType=BIGINT}, #{filterCount,jdbcType=BIGINT}, ",
        "#{writeCount,jdbcType=BIGINT}, #{readSkipCount,jdbcType=BIGINT}, ",
        "#{writeSkipCount,jdbcType=BIGINT}, #{processSkipCount,jdbcType=BIGINT}, ",
        "#{rollbackCount,jdbcType=BIGINT}, #{exitCode,jdbcType=VARCHAR}, ",
        "#{exitMessage,jdbcType=VARCHAR}, #{lastUpdated,jdbcType=TIMESTAMP})"
    })
    int insert(BatchStepExecution record);

    @InsertProvider(type=BatchStepExecutionSqlProvider.class, method="insertSelective")
    int insertSelective(BatchStepExecution record);

    @SelectProvider(type=BatchStepExecutionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="STEP_NAME", property="stepName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMIT_COUNT", property="commitCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_COUNT", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="FILTER_COUNT", property="filterCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_COUNT", property="writeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_SKIP_COUNT", property="readSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_SKIP_COUNT", property="writeSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="PROCESS_SKIP_COUNT", property="processSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="ROLLBACK_COUNT", property="rollbackCount", jdbcType=JdbcType.BIGINT),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BatchStepExecution> selectByExampleWithRowbounds(BatchStepExecutionExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchStepExecutionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="STEP_NAME", property="stepName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMIT_COUNT", property="commitCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_COUNT", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="FILTER_COUNT", property="filterCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_COUNT", property="writeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_SKIP_COUNT", property="readSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_SKIP_COUNT", property="writeSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="PROCESS_SKIP_COUNT", property="processSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="ROLLBACK_COUNT", property="rollbackCount", jdbcType=JdbcType.BIGINT),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BatchStepExecution> selectByExample(BatchStepExecutionExample example);

    @Select({
        "select",
        "STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, START_TIME, END_TIME, ",
        "STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, ",
        "WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, ",
        "LAST_UPDATED",
        "from BATCH_STEP_EXECUTION",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="STEP_EXECUTION_ID", property="stepExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="STEP_NAME", property="stepName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMIT_COUNT", property="commitCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_COUNT", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="FILTER_COUNT", property="filterCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_COUNT", property="writeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_SKIP_COUNT", property="readSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="WRITE_SKIP_COUNT", property="writeSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="PROCESS_SKIP_COUNT", property="processSkipCount", jdbcType=JdbcType.BIGINT),
        @Result(column="ROLLBACK_COUNT", property="rollbackCount", jdbcType=JdbcType.BIGINT),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP)
    })
    BatchStepExecution selectByPrimaryKey(Long stepExecutionId);

    @UpdateProvider(type=BatchStepExecutionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchStepExecution record, @Param("example") BatchStepExecutionExample example);

    @UpdateProvider(type=BatchStepExecutionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchStepExecution record, @Param("example") BatchStepExecutionExample example);

    @UpdateProvider(type=BatchStepExecutionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BatchStepExecution record);

    @Update({
        "update BATCH_STEP_EXECUTION",
        "set VERSION = #{version,jdbcType=BIGINT},",
          "STEP_NAME = #{stepName,jdbcType=VARCHAR},",
          "JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT},",
          "START_TIME = #{startTime,jdbcType=TIMESTAMP},",
          "END_TIME = #{endTime,jdbcType=TIMESTAMP},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "COMMIT_COUNT = #{commitCount,jdbcType=BIGINT},",
          "READ_COUNT = #{readCount,jdbcType=BIGINT},",
          "FILTER_COUNT = #{filterCount,jdbcType=BIGINT},",
          "WRITE_COUNT = #{writeCount,jdbcType=BIGINT},",
          "READ_SKIP_COUNT = #{readSkipCount,jdbcType=BIGINT},",
          "WRITE_SKIP_COUNT = #{writeSkipCount,jdbcType=BIGINT},",
          "PROCESS_SKIP_COUNT = #{processSkipCount,jdbcType=BIGINT},",
          "ROLLBACK_COUNT = #{rollbackCount,jdbcType=BIGINT},",
          "EXIT_CODE = #{exitCode,jdbcType=VARCHAR},",
          "EXIT_MESSAGE = #{exitMessage,jdbcType=VARCHAR},",
          "LAST_UPDATED = #{lastUpdated,jdbcType=TIMESTAMP}",
        "where STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BatchStepExecution record);
}