package com.soft1851.springbootjpa.service;

import com.soft1851.springbootjpa.dto.UserDetailParam;
import com.soft1851.springbootjpa.model.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Tao
 */
public interface UserDetailService {
    /**
     *
     * @param detailParam
     * @param pageable
     * @return
     */
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
