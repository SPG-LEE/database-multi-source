package com.database.source.entity;

import lombok.Data;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "USER_AUTH_", uniqueConstraints = {@UniqueConstraint(name = "USER_AUTH_PHONE", columnNames = {"PHONE"}),
        @UniqueConstraint(name = "USER_AUTH_EMAIL", columnNames = {"EMAIL"})})
public class UserAuthEntity implements Serializable {
    private static final long serialVersionUID = 7230052310725727465L;
    @Id
    @GeneratedValue(generator = "user_id" )
    @GenericGenerator(name = "user_id",strategy = "com.database.source.config.SnowflakeGenerator")
    private Long id;
    @Column(name = "PHONE", length = 16)
    private String phone;
    @Column(name = "EMAIL", length = 16)
    private String email;
    private String password;
    @Column(name = "REMARK",length = 16)
    private String remark;
    @Column(name = "COUNTRY",length = 16)
    private String country;
    @Column(name = "ADD_DATE", nullable = false, columnDefinition = "datetime default now()")
    private Date addDate;
}