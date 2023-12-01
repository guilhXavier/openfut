package br.com.gtx.openfut.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.dto.LeagueFormDto;
import br.com.gtx.openfut.service.LeagueService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/league")
@AllArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;

    @GetMapping
    Iterable<League> findAll() {
        return leagueService.findAll();
    }

    @PostMapping
    void create(@RequestBody LeagueFormDto leagueFormDto, @RequestParam Long ownerId) {
        leagueService.create(leagueFormDto, ownerId);
    }

    @PostMapping("/join")
    void joinLeague(@RequestParam Long teamId, @RequestParam Long leagueId) {
        leagueService.addTeamToLeague(teamId, leagueId);
    }

    @GetMapping("/team/{teamId}")
    ResponseEntity<Iterable<League>> findAllByTeam(@PathVariable final Long teamId) {
        Iterable<League> findAllByTeam = leagueService.findAllByTeam(teamId);

        return ResponseEntity.ok(findAllByTeam);
    }

    @GetMapping("/owner/{userId}")
    ResponseEntity<Iterable<League>> findAllByOwner(@PathVariable final Long userId) {
        Iterable<League> findAllByOwner = leagueService.findAllByOwner(userId);

        return ResponseEntity.ok(findAllByOwner);
    }

}
