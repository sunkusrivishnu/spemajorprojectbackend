package com.example.cricketdemo.Controller;

import com.example.cricketdemo.controller.TeamController;
import com.example.cricketdemo.model.Team;
import com.example.cricketdemo.repository.TeamRepository;
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

import static org.mockito.Mockito.*;

public class MatchTest {

    private MockMvc mockMvc;

    @Mock
    private TeamRepository teamRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        TeamController teamController = new TeamController(teamRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
    }

    @Test
    void testNewTeam() throws Exception {

        Team newTeam = new Team();
        newTeam.setTeamID(1L);
        newTeam.setTname("testtname");

        when(teamRepository.save(any(Team.class))).thenReturn(newTeam);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/addteam")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTeam)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.teamID").value(newTeam.getTeamID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tname").value(newTeam.getTname()));

        verify(teamRepository, times(1)).save(any(Team.class));
    }


    }
