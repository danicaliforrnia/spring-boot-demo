package com.dstefanelli.springbootdemo.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClanEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column()
    private String name;
}
