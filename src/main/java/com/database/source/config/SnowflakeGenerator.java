package com.database.source.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import io.shardingsphere.core.keygen.KeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Properties;

public class SnowflakeGenerator implements IdentifierGenerator {
    public SnowflakeGenerator() {
    }

//    @Override
//    public Number generateKey() {
//        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
//        Long id = snowflake.nextId();
//        System.out.println("我自定义的id" + id);
//        return id;
//    }

    @Override public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        Long id = snowflake.nextId();
        System.out.println("我自定义的id" + id);
        return id;
    }

    @Override public boolean supportsJdbcBatchInserts() {
        return false;
    }

//    @Override
//    public Comparable<?> generateKey() {
//        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
//        Long id = snowflake.nextId();
//        System.out.println("我自定义的id" + id);
//        return id;
//    }
//
//    @Override
//    public String getType() {
//        return "SnowflakeGenerator";
//    }
//
//    @Override
//    public Properties getProperties() {
//        return null;
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }


}
