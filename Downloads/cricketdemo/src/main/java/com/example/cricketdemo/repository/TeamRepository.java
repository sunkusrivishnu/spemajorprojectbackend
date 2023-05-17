package com.example.cricketdemo.repository;

import com.example.cricketdemo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
