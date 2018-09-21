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
import org.vincent.dao.model.BatchJobExecutionSeq;
import org.vincent.dao.model.BatchJobExecutionSeqExample;

public interface BatchJobExecutionSeqMapper {
    @SelectProvider(type=BatchJobExecutionSeqSqlProvider.class, method="countByExample")
    long countByExample(BatchJobExecutionSeqExample example);

    @DeleteProvider(type=BatchJobExecutionSeqSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobExecutionSeqExample example);

    @Insert({
        "insert into BATCH_JOB_EXECUTION_SEQ (ID, UNIQUE_KEY)",
        "values (#{id,jdbcType=BIGINT}, #{uniqueKey,jdbcType=CHAR})"
    })
    int insert(BatchJobExecutionSeq record);

    @InsertProvider(type=BatchJobExecutionSeqSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobExecutionSeq record);

    @SelectProvider(type=BatchJobExecutionSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobExecutionSeq> selectByExampleWithRowbounds(BatchJobExecutionSeqExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobExecutionSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobExecutionSeq> selectByExample(BatchJobExecutionSeqExample example);

    @UpdateProvider(type=BatchJobExecutionSeqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobExecutionSeq record, @Param("example") BatchJobExecutionSeqExample example);

    @UpdateProvider(type=BatchJobExecutionSeqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobExecutionSeq record, @Param("example") BatchJobExecutionSeqExample example);
}