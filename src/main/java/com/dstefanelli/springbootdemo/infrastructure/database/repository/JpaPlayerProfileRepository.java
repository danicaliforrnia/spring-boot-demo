package com.dstefanelli.springbootdemo.infrastructure.database.repository;

import com.dstefanelli.springbootdemo.infrastructure.database.entities.PlayerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPlayerProfileRepository extends JpaRepository<PlayerProfileEntity, UUID> {
}
