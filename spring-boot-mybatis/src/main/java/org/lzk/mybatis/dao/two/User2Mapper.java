package org.lzk.mybatis.dao.two;

import org.lzk.mybatis.common.UserParam;
import org.lzk.mybatis.model.User;

import java.util.List;

public interface User2Mapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

    List<User> getList(UserParam userParam);
    int getCount(UserParam userParam);



}