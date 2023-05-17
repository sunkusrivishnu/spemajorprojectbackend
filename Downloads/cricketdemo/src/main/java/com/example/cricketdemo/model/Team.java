package com.example.cricketdemo.model;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long teamID;

    private String tname;

    public Team()
    {

    }

    public Team(String tname)
    {
        this.tname = tname;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
