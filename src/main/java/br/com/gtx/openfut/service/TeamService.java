package br.com.gtx.openfut.service;

import java.util.Optional;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.TeamFormDTO;

public interface TeamService {
    Team save(TeamFormDTO teamFormDTO);

    void update(TeamFormDTO teamFormDTO);

    Iterable<Team> findByNameContains(String name);

    Optional<Team> findById(Long id);

    Iterable<Team> findAll();

    Iterable<AppUser> getPlayersByTeamId(Long id);

    void delete(Long id);

    void addPlayer(Long teamId, Long playerId);

}
