package com.odinwatcb.odinwatch.producer.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "odin-USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true,nullable = false)
    private String email;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Column(nullable = false,length = 20)
    private String password;

    @OneToMany
    private Set<ServiceEntity> services;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;


    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }
}
