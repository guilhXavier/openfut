package br.com.gtx.openfut.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.LeagueFormDto;
import br.com.gtx.openfut.mapper.LeagueMapper;
import br.com.gtx.openfut.repository.AppUserRepository;
import br.com.gtx.openfut.repository.LeagueRepository;
import br.com.gtx.openfut.repository.TeamRepository;
import br.com.gtx.openfut.service.LeagueService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    private final TeamRepository teamRepository;

    private final AppUserRepository appUserRepository;

    private final LeagueMapper mapper;

    @Override
    public void create(LeagueFormDto leagueFormDto, Long ownerId) {
        League league = mapper.apply(leagueFormDto);

        AppUser owner = appUserRepository.findById(ownerId).get();

        league.setOwner(owner);

        leagueRepository.save(league);
    }

    @Override
    public Iterable<League> findAll() {
        return leagueRepository.findAll();
    }

    @Override
    public Iterable<League> findAllByTeam(Long teamId) {
        return leagueRepository.findByTeams_id(teamId);
    }

    @Override
    public Iterable<League> findAllByOwner(Long userId) {
        AppUser user = appUserRepository.findById(userId).get();

        return leagueRepository.findByOwner(user);
    }

    @Override
    public void addTeamToLeague(Long teamId, Long leagueId) {
        Team team = teamRepository.findById(teamId).get();

        League league = leagueRepository.findById(leagueId).get();

        List<League> leagues = team.getLeagues();

        leagues.add(league);

        team.setLeagues(leagues);

        teamRepository.save(team);
    }

}
