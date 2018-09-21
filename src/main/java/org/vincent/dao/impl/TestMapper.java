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
import org.vincent.dao.model.Test;
import org.vincent.dao.model.TestExample;

public interface TestMapper {
    @SelectProvider(type=TestSqlProvider.class, method="countByExample")
    long countByExample(TestExample example);

    @DeleteProvider(type=TestSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestExample example);

    @Delete({
        "delete from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into test (id, bl)",
        "values (#{id,jdbcType=INTEGER}, #{bl,jdbcType=BIT})"
    })
    int insert(Test record);

    @InsertProvider(type=TestSqlProvider.class, method="insertSelective")
    int insertSelective(Test record);

    @SelectProvider(type=TestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bl", property="bl", jdbcType=JdbcType.BIT)
    })
    List<Test> selectByExampleWithRowbounds(TestExample example, RowBounds rowBounds);

    @SelectProvider(type=TestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bl", property="bl", jdbcType=JdbcType.BIT)
    })
    List<Test> selectByExample(TestExample example);

    @Select({
        "select",
        "id, bl",
        "from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bl", property="bl", jdbcType=JdbcType.BIT)
    })
    Test selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Test record);

    @Update({
        "update test",
        "set bl = #{bl,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Test record);
}