package com.co.commonservice.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Corregido: 'strategy' en lugar de 'stretegy'
    private Long id;

    private String nombre;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
