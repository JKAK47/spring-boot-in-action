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
import org.vincent.dao.model.BatchStepExecutionSeq;
import org.vincent.dao.model.BatchStepExecutionSeqExample;

public interface BatchStepExecutionSeqMapper {
    @SelectProvider(type=BatchStepExecutionSeqSqlProvider.class, method="countByExample")
    long countByExample(BatchStepExecutionSeqExample example);

    @DeleteProvider(type=BatchStepExecutionSeqSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchStepExecutionSeqExample example);

    @Insert({
        "insert into BATCH_STEP_EXECUTION_SEQ (ID, UNIQUE_KEY)",
        "values (#{id,jdbcType=BIGINT}, #{uniqueKey,jdbcType=CHAR})"
    })
    int insert(BatchStepExecutionSeq record);

    @InsertProvider(type=BatchStepExecutionSeqSqlProvider.class, method="insertSelective")
    int insertSelective(BatchStepExecutionSeq record);

    @SelectProvider(type=BatchStepExecutionSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchStepExecutionSeq> selectByExampleWithRowbounds(BatchStepExecutionSeqExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchStepExecutionSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchStepExecutionSeq> selectByExample(BatchStepExecutionSeqExample example);

    @UpdateProvider(type=BatchStepExecutionSeqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchStepExecutionSeq record, @Param("example") BatchStepExecutionSeqExample example);

    @UpdateProvider(type=BatchStepExecutionSeqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchStepExecutionSeq record, @Param("example") BatchStepExecutionSeqExample example);
}