package br.com.gtx.openfut.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.MatchFormDto;
import br.com.gtx.openfut.mapper.MatchMapper;
import br.com.gtx.openfut.repository.MatchRepository;
import br.com.gtx.openfut.repository.TeamRepository;
import br.com.gtx.openfut.service.MatchService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    private final TeamRepository teamRepository;

    private final MatchMapper mapper;

    @Override
    public Iterable<Match> findAllByLeague(Long leagueId) {
        return matchRepository.find;
    }

    @Override
    public void save(MatchFormDto matchFormDto) {
        Match match = mapper.apply(matchFormDto);

        matchRepository.save(match);
    }

    @Override
    public Optional<Match> findById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public Iterable<Match> findAllByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).get();

        return matchRepository.findAllByTeam(team);
    }

    @Override
    public Iterable<Match> findAllByTeamAndLeague(Long teamId, Long leagueId) {
        Team team = teamRepository.findById(teamId).get();

        return matchRepository.findAllByTeamAndLeague(team, null);
    }

}
