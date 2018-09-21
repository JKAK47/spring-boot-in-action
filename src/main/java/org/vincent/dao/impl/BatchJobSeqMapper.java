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
import org.vincent.dao.model.BatchJobSeq;
import org.vincent.dao.model.BatchJobSeqExample;

public interface BatchJobSeqMapper {
    @SelectProvider(type=BatchJobSeqSqlProvider.class, method="countByExample")
    long countByExample(BatchJobSeqExample example);

    @DeleteProvider(type=BatchJobSeqSqlProvider.class, method="deleteByExample")
    int deleteByExample(BatchJobSeqExample example);

    @Insert({
        "insert into BATCH_JOB_SEQ (ID, UNIQUE_KEY)",
        "values (#{id,jdbcType=BIGINT}, #{uniqueKey,jdbcType=CHAR})"
    })
    int insert(BatchJobSeq record);

    @InsertProvider(type=BatchJobSeqSqlProvider.class, method="insertSelective")
    int insertSelective(BatchJobSeq record);

    @SelectProvider(type=BatchJobSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobSeq> selectByExampleWithRowbounds(BatchJobSeqExample example, RowBounds rowBounds);

    @SelectProvider(type=BatchJobSeqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="UNIQUE_KEY", property="uniqueKey", jdbcType=JdbcType.CHAR)
    })
    List<BatchJobSeq> selectByExample(BatchJobSeqExample example);

    @UpdateProvider(type=BatchJobSeqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BatchJobSeq record, @Param("example") BatchJobSeqExample example);

    @UpdateProvider(type=BatchJobSeqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BatchJobSeq record, @Param("example") BatchJobSeqExample example);
}