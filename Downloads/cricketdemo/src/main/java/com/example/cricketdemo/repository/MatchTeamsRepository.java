package com.example.cricketdemo.repository;

import com.example.cricketdemo.model.MatchTeams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchTeamsRepository extends JpaRepository<MatchTeams, Long> {
    Optional<MatchTeams> findByMatchID(Long matchid);
    MatchTeams getAllByMatchID(Long matchid);
}
