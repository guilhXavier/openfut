package br.com.gtx.openfut.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.MatchFormDto;
import br.com.gtx.openfut.mapper.MatchMapper;
import br.com.gtx.openfut.repository.CourtRepository;
import br.com.gtx.openfut.repository.LeagueRepository;
import br.com.gtx.openfut.repository.MatchRepository;
import br.com.gtx.openfut.repository.TeamRepository;
import br.com.gtx.openfut.service.MatchService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    private final CourtRepository courtRepository;

    private final LeagueRepository leagueRepository;

    private final TeamRepository teamRepository;

    @Override
    public Iterable<Match> findAllByLeague(Long leagueId) {
        League league = leagueRepository.findById(leagueId).get();

        return matchRepository.findAllByLeague(league);
    }

    @Override
    public Optional<Match> findById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public Iterable<Match> findAllByHomeTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).get();

        return matchRepository.findAllByHomeTeam(team);
    }

    @Override
    public Iterable<Match> findAllByHomeTeamAndLeague(Long teamId, Long leagueId) {
        Team team = teamRepository.findById(teamId).get();

        League league = leagueRepository.findById(leagueId).get();

        return matchRepository.findAllByHomeTeamAndLeague(team, league);
    }

    @Override
    public void create(Long homeTeamId, Long awayTeamId, Long courtId, Long leagueId) {
        Team homeTeam = teamRepository.findById(homeTeamId).get();

        Team awayTeam = teamRepository.findById(awayTeamId).get();

        Court court = courtRepository.findById(courtId).get();

        League league = leagueRepository.findById(leagueId).get();

        Match match = new Match();

        match.setHomeTeam(homeTeam);
        match.setHomeScore(0);

        match.setAwayTeam(awayTeam);
        match.setAwayScore(0);

        match.setCourt(court);
        match.setLeague(league);

        matchRepository.save(match);
    }

}
