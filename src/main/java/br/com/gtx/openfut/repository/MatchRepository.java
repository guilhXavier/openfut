package br.com.gtx.openfut.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.domain.entity.Team;

public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findAllByLeague(League league);

    Iterable<Match> findAllByHomeTeam(Team team);

    Optional<Match> findById(Long matchId);

    Iterable<Match> findAllByHomeTeamAndLeague(Team homeTeam, League league);
}
