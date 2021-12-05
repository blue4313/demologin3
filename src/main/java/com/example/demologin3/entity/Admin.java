package com.example.demologin3.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Data
@Table(name = "tz_admin_user")
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_seq")
    private int adminSeq;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "admin_pw")
    private String adminPw;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_role")
    private String adminRole;

    @Column(name = "email")
    private String email;

    @Column(name = "reg_date")
    private ZonedDateTime regDate;
}
