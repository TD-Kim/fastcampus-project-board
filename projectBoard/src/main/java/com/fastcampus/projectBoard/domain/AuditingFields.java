package com.fastcampus.projectBoard.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingFields {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate 
    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy 
    @Column(nullable = false, length = 100, updatable = false) 
    private String createdBy; // 생성자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false) 
    private LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy 
    @Column(nullable = false, length = 100) 
    private String modifiedBy; // 수정자
}
