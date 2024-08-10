package com.odinwatcb.odinwatch.producer.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Event")
public class EventEntity {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String event_name;

    @ManyToOne
    @JoinColumn(name= "com/odinwatcb/odinwatch/producer/service")
    private ServiceEntity service;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
