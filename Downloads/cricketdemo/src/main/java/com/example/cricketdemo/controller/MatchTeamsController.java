package com.example.cricketdemo.controller;

import com.example.cricketdemo.model.MatchTeams;
import com.example.cricketdemo.repository.MatchTeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MatchTeamsController {

    @Autowired
    private MatchTeamsRepository matchRepository;

    @Autowired
    public MatchTeamsController(MatchTeamsRepository matchTeamsRepository)
    {
        this.matchRepository = matchTeamsRepository;
    }
    @PostMapping("/api/addmatch")
    MatchTeams newMatch(@RequestBody MatchTeams newMatch)
    {
        return matchRepository.save(newMatch);
    }

    @PutMapping("/api/updatemdet")
    public boolean updateFirstBattingTeam(@RequestBody Map<String, String> Updatedet)
    {
        Long matchid = Long.parseLong(Updatedet.get("matchid"));
        Long firstbattingtid = Long.parseLong(Updatedet.get("firstbattingtid"));
        String firstbattingtname = Updatedet.get("firstbattingtname");

        Optional<MatchTeams> optionalMatchTeam = matchRepository.findByMatchID(matchid);

        if (optionalMatchTeam.isPresent())
        {
            MatchTeams matchTeam = optionalMatchTeam.get();
            matchTeam.setFirstbattingtID(firstbattingtid);
            matchTeam.setFirstbattingtname(firstbattingtname);
            matchRepository.save(matchTeam);
            return true;
        }

       return false;
    }

    @GetMapping("/api/getmdetails")
    MatchTeams getmatchdetailsbymatchid(@RequestParam("matchid") Long matachid)
    {
        return matchRepository.getAllByMatchID(matachid);
    }
}
