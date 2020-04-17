package com.database.source.controller;

import com.alibaba.fastjson.JSONObject;
import com.database.source.entity.UserAuthEntity;
import com.database.source.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/save")
    public String save() {
        for (int i = 0; i < 100; i++) {
            List<String> countries = new ArrayList<>();
            countries.add("UK");
            countries.add("DE");
            countries.add("FR");
            UserAuthEntity userAuthEntity = new UserAuthEntity();
            userAuthEntity.setId((long) i);
            userAuthEntity.setAddDate(new Date());
            userAuthEntity.setEmail("test" + i + "@163.com");
            userAuthEntity.setPassword("123456");
            userAuthEntity.setPhone("1388888888" + i);
            userAuthEntity.setCountry(countries.get(i % 3));
            Random r = new Random();
            userAuthEntity.setRemark("" + r.nextInt(100));
            userAuthService.save(userAuthEntity);
        }
        return "success";
    }

    @PostMapping("/select")
    public String select() {
        return JSONObject.toJSONString(userAuthService.findAll());
    }
    @PostMapping("/{id}/select")
    public String select(@PathVariable long id) {
        return JSONObject.toJSONString(userAuthService.findById(id));
    }
}