package com.example.cricketdemo.Controller;

import com.example.cricketdemo.controller.MatchTeamsController;
import com.example.cricketdemo.controller.TeamController;
import com.example.cricketdemo.model.MatchTeams;
import com.example.cricketdemo.model.Team;
import com.example.cricketdemo.repository.MatchTeamsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MatchTeamsTest {

    private MockMvc mockMvc;

    @Mock
    private MatchTeamsRepository matchTeamsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        MatchTeamsController matchTeamsController = new MatchTeamsController(matchTeamsRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(matchTeamsController).build();
    }

    @Test
    void testNewMatch() throws Exception {

        MatchTeams newMatch = new MatchTeams();
        newMatch.setMatchID(1L);
        newMatch.setT1ID(1L);
        newMatch.setT2ID(1L);
        newMatch.setNumovers(1L);
        newMatch.setFirstbattingtID(1L);
        newMatch.setFirstbattingtname("testteamname");

        when(matchTeamsRepository.save(any(MatchTeams.class))).thenReturn(newMatch);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/addmatch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newMatch)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.matchID").value(newMatch.getMatchID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.t1ID").value(newMatch.getT1ID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.t2ID").value(newMatch.getT2ID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numovers").value(newMatch.getNumovers()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstbattingtID").value(newMatch.getFirstbattingtID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstbattingtname").value(newMatch.getFirstbattingtname()));

        verify(matchTeamsRepository, times(1)).save(any(MatchTeams.class));
    }

    @Test
    void testGetMatchbyID() throws Exception {
        MatchTeams m1 = new MatchTeams();
        m1.setMatchID(1L);
        m1.setT1ID(1L);
        m1.setT2ID(2L);
        m1.setNumovers(4L);
        m1.setFirstbattingtID(1L);
        m1.setFirstbattingtname("first");

        when(matchTeamsRepository.getAllByMatchID(1L)).thenReturn(m1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/getmdetails")
                        .param("matchid","1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.matchID").value(m1.getMatchID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.t1ID").value(m1.getT1ID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.t2ID").value(m1.getT2ID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numovers").value(m1.getNumovers()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstbattingtID").value(m1.getFirstbattingtID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstbattingtname").value(m1.getFirstbattingtname()));

        verify(matchTeamsRepository, times(1)).getAllByMatchID(1L);

    }
}
