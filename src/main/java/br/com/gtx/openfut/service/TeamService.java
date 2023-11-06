package br.com.gtx.openfut.service;

import java.util.List;
import java.util.Optional;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.TeamFormDTO;

public interface TeamService {
    Team save(TeamFormDTO teamFormDTO);

    void update(TeamFormDTO teamFormDTO);

    Optional<Team> findByName(String name);

    Optional<Team> findById(Long id);

    List<Team> findAll();

    List<AppUser> getPlayersByTeamId(Long id);

}
