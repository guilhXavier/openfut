package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    void save(@RequestBody LeagueFormDto leagueFormDto) {
        leagueService.save(leagueFormDto);
    }

    @GetMapping("/team/{id}")
    Iterable<League> findAllByTeam(@PathVariable final Long id) {
        return leagueService.findAllByTeam(id);
    }

    @GetMapping("/owner/{id}")
    Iterable<League> findAllByOwner(@PathVariable final Long id) {
        return leagueService.findAllByOwner(id);
    }

}
