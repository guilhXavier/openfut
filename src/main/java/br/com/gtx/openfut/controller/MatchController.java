package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.dto.MatchFormDto;
import br.com.gtx.openfut.service.MatchService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/match")
@AllArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    Iterable<Match> findAllByLeague(@RequestParam final Long leagueId) {
        return matchService.findAllByLeague(leagueId);
    }

    @PostMapping
    void save(@RequestBody MatchFormDto matchFormDto) {
        matchService.save(matchFormDto);
    }

    @GetMapping("/{id}")
    Match findById(@PathVariable final Long id) {
        return matchService.findById(id).get();
    }

    @GetMapping("/{id}/all")
    Iterable<Match> findAllByHomeTeam(@PathVariable final Long id) {
        return matchService.findAllByHomeTeam(id);
    }

    @GetMapping("/league/{leagueId}/team/{id}")
    Iterable<Match> findAllByTeam(@PathVariable final Long leagueId, @PathVariable final Long teamId) {
        return matchService.findAllByHomeTeamAndLeague(leagueId, teamId);
    }
}
