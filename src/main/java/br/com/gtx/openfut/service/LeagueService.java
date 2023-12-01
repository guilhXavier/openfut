package br.com.gtx.openfut.service;

import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.dto.LeagueFormDto;

public interface LeagueService {
    void create(LeagueFormDto leagueFormDto, Long ownerId);

    void addTeamToLeague(Long teamId, Long leagueId);

    Iterable<League> findAll();

    Iterable<League> findAllByTeam(Long teamId);

    Iterable<League> findAllByOwner(Long userId);
}
