package com.database.source.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

public class SnowflakeGenerator implements ShardingKeyGenerator {
    @Override
    public Comparable<?> generateKey() {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        Long id = snowflake.nextId();
        System.out.println("我自定义的id" + id);
        return id;
    }

    @Override
    public String getType() {
        return "SnowflakeGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
