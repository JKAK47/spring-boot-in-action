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
import org.vincent.dao.model.BatchJobExecution;
import org.vincent.dao.model.BatchJobExecutionExample;

public interface BatchJobExecutionMapper {
    @SelectProvider(type=BatchJobExecutionSqlProvider.class, method="countByExample")
    long countByExample(BatchJobExecutionExample example);

    @DeleteProvider(type=BatchJobExecutionSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobExecutionExample example);

    @Delete({
        "delete from BATCH_JOB_EXECUTION",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long jobExecutionId);

    @Insert({
        "insert into BATCH_JOB_EXECUTION (JOB_EXECUTION_ID, VERSION, ",
        "JOB_INSTANCE_ID, CREATE_TIME, ",
        "START_TIME, END_TIME, ",
        "STATUS, EXIT_CODE, ",
        "EXIT_MESSAGE, LAST_UPDATED, ",
        "JOB_CONFIGURATION_LOCATION)",
        "values (#{jobExecutionId,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{jobInstanceId,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=VARCHAR}, #{exitCode,jdbcType=VARCHAR}, ",
        "#{exitMessage,jdbcType=VARCHAR}, #{lastUpdated,jdbcType=TIMESTAMP}, ",
        "#{jobConfigurationLocation,jdbcType=VARCHAR})"
    })
    int insert(BatchJobExecution record);

    @InsertProvider(type=BatchJobExecutionSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobExecution record);

    @SelectProvider(type=BatchJobExecutionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="JOB_CONFIGURATION_LOCATION", property="jobConfigurationLocation", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobExecution> selectByExampleWithRowbounds(BatchJobExecutionExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobExecutionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="JOB_CONFIGURATION_LOCATION", property="jobConfigurationLocation", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobExecution> selectByExample(BatchJobExecutionExample example);

    @Select({
        "select",
        "JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, ",
        "STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION",
        "from BATCH_JOB_EXECUTION",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="JOB_EXECUTION_ID", property="jobExecutionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_CODE", property="exitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXIT_MESSAGE", property="exitMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_UPDATED", property="lastUpdated", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="JOB_CONFIGURATION_LOCATION", property="jobConfigurationLocation", jdbcType=JdbcType.VARCHAR)
    })
    BatchJobExecution selectByPrimaryKey(Long jobExecutionId);

    @UpdateProvider(type=BatchJobExecutionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobExecution record, @Param("example") BatchJobExecutionExample example);

    @UpdateProvider(type=BatchJobExecutionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobExecution record, @Param("example") BatchJobExecutionExample example);

    @UpdateProvider(type=BatchJobExecutionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BatchJobExecution record);

    @Update({
        "update BATCH_JOB_EXECUTION",
        "set VERSION = #{version,jdbcType=BIGINT},",
          "JOB_INSTANCE_ID = #{jobInstanceId,jdbcType=BIGINT},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "START_TIME = #{startTime,jdbcType=TIMESTAMP},",
          "END_TIME = #{endTime,jdbcType=TIMESTAMP},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "EXIT_CODE = #{exitCode,jdbcType=VARCHAR},",
          "EXIT_MESSAGE = #{exitMessage,jdbcType=VARCHAR},",
          "LAST_UPDATED = #{lastUpdated,jdbcType=TIMESTAMP},",
          "JOB_CONFIGURATION_LOCATION = #{jobConfigurationLocation,jdbcType=VARCHAR}",
        "where JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BatchJobExecution record);
}