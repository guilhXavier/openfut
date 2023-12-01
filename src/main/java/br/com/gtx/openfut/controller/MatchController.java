package br.com.gtx.openfut.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    ResponseEntity<Iterable<Match>> findAllByLeague(@RequestParam final Long leagueId) {
        return ResponseEntity.ok(matchService.findAllByLeague(leagueId));
    }

    @PostMapping
    void create(@RequestParam Long homeTeamId, @RequestParam Long awayTeamId, @RequestParam Long courtId,
            @RequestParam Long leagueId) {
        matchService.create(homeTeamId, awayTeamId, courtId, leagueId);
    }

    @GetMapping("/{id}")
    ResponseEntity<Match> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(matchService.findById(id).get());
    }

    @GetMapping("/{id}/all")
    ResponseEntity<Iterable<Match>> findAllByHomeTeam(@PathVariable final Long id) {
        return ResponseEntity.ok(matchService.findAllByHomeTeam(id));
    }

    @GetMapping("/league/{leagueId}/team/{id}")
    ResponseEntity<Iterable<Match>> findAllByTeam(@PathVariable final Long leagueId, @PathVariable final Long teamId) {
        return ResponseEntity.ok(matchService.findAllByHomeTeamAndLeague(leagueId, teamId));
    }
}
