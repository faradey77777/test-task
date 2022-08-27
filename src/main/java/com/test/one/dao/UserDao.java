package com.test.one.dao;

import com.test.one.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getInfoByUserId(Integer userId);
    List<User> getInfoByLevelId(Integer levelId);
    Boolean save(User user);
}
