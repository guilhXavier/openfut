package br.com.gtx.openfut.service;

import java.util.Optional;

import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.dto.MatchFormDto;

public interface MatchService {
    Iterable<Match> findAllByLeague(Long leagueId);

    void save(MatchFormDto matchFormDto);

    Optional<Match> findById(Long matchId);

    Iterable<Match> findAllByHomeTeam(Long teamId);

    Iterable<Match> findAllByHomeTeamAndLeague(Long teamId, Long leagueId);
}
