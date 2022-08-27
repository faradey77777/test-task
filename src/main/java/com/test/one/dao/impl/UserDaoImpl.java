package com.test.one.dao.impl;

import com.test.one.dao.UserDao;
import com.test.one.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private ArrayList<User> tmpList = new ArrayList<>();
    private int counter;

    @Override
    public List<User> getInfoByUserId(Integer userId) {
        return tmpList.stream()
                .filter(entity -> entity.getUserId() != null)
                .filter(entity -> entity.getUserId().equals(userId))
                .sorted(Comparator.comparing(User::getResult).thenComparing(User::getLevelId).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getInfoByLevelId(Integer levelId) {
        return tmpList.stream()
                .filter(entity -> entity.getLevelId().equals(levelId))
                .sorted(Comparator.comparing(User::getResult).thenComparing(User::getUserId).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean save(User user) {
        Optional<User> first = tmpList.stream()
                .filter(entity -> entity.getLevelId() != null && entity.getUserId() != null)
                .filter(entity -> entity.getUserId().equals(user.getUserId()))
                .filter(entity -> entity.getLevelId().equals(user.getLevelId()))
                .findFirst();

        if (first.isPresent()) {
            first.get().setResult(user.getResult());
        } else tmpList.add(counter++, user);
        return true;
    }
}
