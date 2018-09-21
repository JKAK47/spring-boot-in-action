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
import org.vincent.dao.model.TbUser;
import org.vincent.dao.model.TbUserExample;

public interface TbUserMapper {
    @SelectProvider(type=TbUserSqlProvider.class, method="countByExample")
    long countByExample(TbUserExample example);

    @DeleteProvider(type=TbUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TbUserExample example);

    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user (id, username, ",
        "age, ctm)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{ctm,jdbcType=TIMESTAMP})"
    })
    int insert(TbUser record);

    @InsertProvider(type=TbUserSqlProvider.class, method="insertSelective")
    int insertSelective(TbUser record);

    @SelectProvider(type=TbUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ctm", property="ctm", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbUser> selectByExampleWithRowbounds(TbUserExample example, RowBounds rowBounds);

    @SelectProvider(type=TbUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ctm", property="ctm", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbUser> selectByExample(TbUserExample example);

    @Select({
        "select",
        "id, username, age, ctm",
        "from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ctm", property="ctm", jdbcType=JdbcType.TIMESTAMP)
    })
    TbUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    @UpdateProvider(type=TbUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    @UpdateProvider(type=TbUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbUser record);

    @Update({
        "update tb_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "ctm = #{ctm,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbUser record);
}