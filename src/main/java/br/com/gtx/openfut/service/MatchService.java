package br.com.gtx.openfut.service;

import java.util.Optional;

import br.com.gtx.openfut.domain.entity.Match;

public interface MatchService {
    Iterable<Match> findAllByLeague(Long leagueId);

    void create(Long homeTeamId, Long awayTeamId, Long courtId, Long leagueId);

    Optional<Match> findById(Long matchId);

    Iterable<Match> findAllByHomeTeam(Long teamId);

    Iterable<Match> findAllByHomeTeamAndLeague(Long teamId, Long leagueId);
}
