package com.example.cricketdemo.controller;

import com.example.cricketdemo.model.Team;
import com.example.cricketdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    @PostMapping("/api/addteam")
    Team newTeam(@RequestBody Team newTeam)
    {
        return teamRepository.save(newTeam);
    }



}
