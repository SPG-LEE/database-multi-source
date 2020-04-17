package com.database.source.service.impl;

import com.database.source.entity.UserAuthEntity;
import com.database.source.repository.UserAuthRepository;
import com.database.source.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public void save(UserAuthEntity entity) {
        userAuthRepository.save(entity);
    }

    @Override
    public List<UserAuthEntity> findAll() {
        return userAuthRepository.findAll(Sort.by(Sort.Order.desc("remark")));
    }

    @Override
    public UserAuthEntity findById(long id) {
        return userAuthRepository.findById(id).orElse(null);
    }


}
