package org.vincent.dao.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.vincent.dao.model.User;

import java.util.List;

/**
 * Created by PengRong on 2018/9/18.
 */
// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中

public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM tb_user")
    List<User> getUserList();

    @Insert("insert into tb_user(username, age, ctm) values(#{username}, #{age}, now())")
    int add(User user);

    @Update("UPDATE tb_user SET username = #{user.username} , age = #{user.age} WHERE id = #{id}")
    int update(@Param("id") Integer id, @Param("user") User user);

    @Delete("DELETE from tb_user where id = #{id} ")
    int delete(Integer id);
}
