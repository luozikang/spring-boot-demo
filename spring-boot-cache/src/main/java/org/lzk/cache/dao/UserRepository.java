package org.lzk.cache.dao;

import org.lzk.cache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Long> {
    List<User> findByNickName(String nickname);


}
