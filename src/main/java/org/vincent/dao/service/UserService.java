package org.vincent.dao.service;

import org.vincent.dao.model.User;

import java.util.List;

/**
 * Created by PengRong on 2018/9/18.
 */

public interface UserService {

    User getUserById(Integer id);

    List<User> getUserList();

    int add(User user);

    int update(Integer id, User user);

    int delete(Integer id);

}
