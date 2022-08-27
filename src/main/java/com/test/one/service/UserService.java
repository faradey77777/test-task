package com.test.one.service;


import com.test.one.dao.UserDao;
import com.test.one.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    @Transactional(readOnly = true)
    public List<User> getInfoByUserId(Integer userId) {
        return userDao.getInfoByUserId(userId);
    }
    @Transactional(readOnly = true)
    public List<User> getInfoByLevelId(Integer levelId) {
        return userDao.getInfoByLevelId(levelId);
    }
    @Transactional
    public Boolean saveUserAndChangeResult(User request) {
        return userDao.save(request);
    }
}
