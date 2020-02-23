package org.lzk.jpa.service;

import org.lzk.jpa.common.UserDetailParam;
import org.lzk.jpa.entity.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}