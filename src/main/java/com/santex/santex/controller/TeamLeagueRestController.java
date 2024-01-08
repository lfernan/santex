package com.santex.santex.controller;

import com.santex.santex.dto.response.PersonDTO;
import com.santex.santex.dto.response.TeamDTO;
import com.santex.santex.service.FootballLeagueService;
import com.santex.santex.service.PersonService;
import com.santex.santex.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("santex/api")
public class TeamLeagueRestController {

    private final FootballLeagueService footballLeagueService;
    private final PersonService personService;
    private final TeamService teamService;

    @Autowired
    public TeamLeagueRestController(FootballLeagueService footballLeagueService, PersonService personService, TeamService teamService) {
        this.footballLeagueService = footballLeagueService;
        this.personService = personService;
        this.teamService = teamService;
    }

    @GetMapping(value = "/importLeague/{leagueCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> importLeague(@PathVariable String leagueCode) {
        return new ResponseEntity<>(footballLeagueService.importLeague(leagueCode), HttpStatus.CREATED);
    }

    @GetMapping(value = "/league/{leagueCode}/players", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List< ? extends PersonDTO>> players(@PathVariable String leagueCode,
                                                   @RequestParam(required = false) String teamName) {
        return new ResponseEntity<>(personService.getPlayersOrCoachByLeagueAndTeamName(leagueCode, teamName), HttpStatus.OK);
    }

    @GetMapping(value = "/team", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TeamDTO> teams(@RequestParam(required = false) String teamName,
                                         @RequestParam(required = false, defaultValue = "false") boolean includeMembers) {
        return new ResponseEntity<>(teamService.getTeamDTOByName(teamName, includeMembers), HttpStatus.OK);
    }
}
