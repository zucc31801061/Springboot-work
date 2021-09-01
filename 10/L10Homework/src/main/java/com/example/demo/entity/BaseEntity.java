package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    private Long createTime;

    @LastModifiedDate
    private Long updateTime;

    @Column(name = "create_by")
    @CreatedBy
    private Long createBy;

    @Column(name = "lastmodified_by")
    @LastModifiedBy
    private String lastmodifiedBy;
}