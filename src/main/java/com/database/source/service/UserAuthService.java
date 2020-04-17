package com.database.source.service;

import com.database.source.entity.UserAuthEntity;

import java.util.List;

public interface UserAuthService {
    void save(UserAuthEntity entity);

    List<UserAuthEntity> findAll();

    UserAuthEntity findById(long id);
}
