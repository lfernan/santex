package com.santex.santex.controller;

import com.santex.santex.service.FootballLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("santex/api")
public class LoadDataRestController {

    private final FootballLeagueService footballLeagueService;

    @Autowired
    public LoadDataRestController(FootballLeagueService footballLeagueService) {
        this.footballLeagueService = footballLeagueService;
    }

    @GetMapping("/importLeague/{leagueCode}")
    @ResponseBody
    public String importLeague(@PathVariable String leagueCode) {
        return footballLeagueService.importLeague(leagueCode);
    }
}
