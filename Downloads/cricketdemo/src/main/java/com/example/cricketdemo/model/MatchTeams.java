package com.example.cricketdemo.model;

import jakarta.persistence.*;

@Entity
public class MatchTeams {

    @Id
    @GeneratedValue
    private Long matchID;
    private Long t1ID;
    private Long t2ID;
    private Long numovers;
    private Long firstbattingtID;
    private String firstbattingtname;

    public MatchTeams() {

    }

    public MatchTeams(Long t1ID, Long t2ID, Long numovers, Long firstbattingtID, String firstbattingtname) {
        this.t1ID = t1ID;
        this.t2ID = t2ID;
        this.numovers = numovers;
        this.firstbattingtID = firstbattingtID;
        this.firstbattingtname = firstbattingtname;
    }

    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

    public Long getT1ID() {
        return t1ID;
    }

    public void setT1ID(Long t1ID) {
        this.t1ID = t1ID;
    }

    public Long getT2ID() {
        return t2ID;
    }

    public void setT2ID(Long t2ID) {
        this.t2ID = t2ID;
    }

    public Long getNumovers() {
        return numovers;
    }

    public void setNumovers(Long numovers) {
        this.numovers = numovers;
    }

    public Long getFirstbattingtID() {
        return firstbattingtID;
    }

    public void setFirstbattingtID(Long firstbattingtID) {
        this.firstbattingtID = firstbattingtID;
    }

    public String getFirstbattingtname() {
        return firstbattingtname;
    }

    public void setFirstbattingtname(String firstbattingtname) {
        this.firstbattingtname = firstbattingtname;
    }
}
