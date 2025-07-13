package com.dstefanelli.springbootdemo.infrastructure.database.repository;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;
import com.dstefanelli.springbootdemo.domain.repository.PlayerProfileRepository;
import com.dstefanelli.springbootdemo.infrastructure.database.mapper.PlayerProfileEntityToModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostgresPlayerProfileRepository implements PlayerProfileRepository {
    private final JpaPlayerProfileRepository repository;

    public PostgresPlayerProfileRepository(JpaPlayerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PlayerProfile> findById(UUID playerId) {
        return repository.findById(playerId)
                .map(PlayerProfileEntityToModelMapper::map);
    }
}
