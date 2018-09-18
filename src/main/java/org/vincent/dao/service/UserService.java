package org.vincent.dao.service;

import org.vincent.dao.model.User;

import java.util.List;

/**
 * Created by PengRong on 2018/9/18.
 */

public interface UserService {

    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);

}
