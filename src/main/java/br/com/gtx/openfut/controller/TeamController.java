package br.com.gtx.openfut.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.TeamFormDTO;
import br.com.gtx.openfut.service.TeamService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    Iterable<Team> findAll() {
        return teamService.findAll();
    }

    @PostMapping
    Team createTeam(@RequestBody final TeamFormDTO teamFormDTO) {
        return teamService.save(teamFormDTO);
    }

    @PatchMapping
    void updateTeam(@RequestBody final TeamFormDTO teamFormDTO) {
        teamService.update(teamFormDTO);
    }

    @DeleteMapping
    void deleteTeam(@RequestParam Long id) {
        teamService.delete(id);
    }

    @GetMapping("/{id}")
    Team findById(@PathVariable final Long id) {
        Optional<Team> team = teamService.findById(id);

        if (team.isPresent()) {
            return team.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/team")
    Iterable<Team> findByNameContaining(@RequestParam final String name) {
        Iterable<Team> team = teamService.findByNameContains(name);

        return team;
    }

    @PatchMapping("/add-player")
    void addPlayer(@RequestParam final Long teamId, @RequestParam final Long playerId) {
        teamService.addPlayer(teamId, playerId);
    }
}
