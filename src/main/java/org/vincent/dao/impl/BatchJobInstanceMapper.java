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
import org.vincent.dao.model.BatchJobInstance;
import org.vincent.dao.model.BatchJobInstanceExample;

public interface BatchJobInstanceMapper {
    @SelectProvider(type=BatchJobInstanceSqlProvider.class, method="countByExample")
    long countByExample(BatchJobInstanceExample example);

    @DeleteProvider(type=BatchJobInstanceSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobInstanceExample example);

    @Delete({
        "delete from BATCH_JOB_INSTANCE",
        "where JOB_INSTANCE_ID = #{jobInstanceId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long jobInstanceId);

    @Insert({
        "insert into BATCH_JOB_INSTANCE (JOB_INSTANCE_ID, VERSION, ",
        "JOB_NAME, JOB_KEY)",
        "values (#{jobInstanceId,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{jobName,jdbcType=VARCHAR}, #{jobKey,jdbcType=VARCHAR})"
    })
    int insert(BatchJobInstance record);

    @InsertProvider(type=BatchJobInstanceSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobInstance record);

    @SelectProvider(type=BatchJobInstanceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_NAME", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_KEY", property="jobKey", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobInstance> selectByExampleWithRowbounds(BatchJobInstanceExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobInstanceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_NAME", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_KEY", property="jobKey", jdbcType=JdbcType.VARCHAR)
    })
    List<BatchJobInstance> selectByExample(BatchJobInstanceExample example);

    @Select({
        "select",
        "JOB_INSTANCE_ID, VERSION, JOB_NAME, JOB_KEY",
        "from BATCH_JOB_INSTANCE",
        "where JOB_INSTANCE_ID = #{jobInstanceId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="JOB_INSTANCE_ID", property="jobInstanceId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="JOB_NAME", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_KEY", property="jobKey", jdbcType=JdbcType.VARCHAR)
    })
    BatchJobInstance selectByPrimaryKey(Long jobInstanceId);

    @UpdateProvider(type=BatchJobInstanceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobInstance record, @Param("example") BatchJobInstanceExample example);

    @UpdateProvider(type=BatchJobInstanceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobInstance record, @Param("example") BatchJobInstanceExample example);

    @UpdateProvider(type=BatchJobInstanceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BatchJobInstance record);

    @Update({
        "update BATCH_JOB_INSTANCE",
        "set VERSION = #{version,jdbcType=BIGINT},",
          "JOB_NAME = #{jobName,jdbcType=VARCHAR},",
          "JOB_KEY = #{jobKey,jdbcType=VARCHAR}",
        "where JOB_INSTANCE_ID = #{jobInstanceId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BatchJobInstance record);
}