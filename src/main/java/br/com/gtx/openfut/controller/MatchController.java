package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.service.MatchService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/match")
@AllArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping()
    Iterable<Match> findAllByLeague(@RequestParam final Long leagueId) {
        return matchService.findAllByLeague(leagueId);
    }
}
