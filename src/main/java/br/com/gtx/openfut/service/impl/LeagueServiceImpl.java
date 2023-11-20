package br.com.gtx.openfut.service.impl;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.dto.LeagueFormDto;
import br.com.gtx.openfut.mapper.LeagueMapper;
import br.com.gtx.openfut.repository.AppUserRepository;
import br.com.gtx.openfut.repository.LeagueRepository;
import br.com.gtx.openfut.service.LeagueService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    private final AppUserRepository appUserRepository;

    private final LeagueMapper mapper;

    @Override
    public void save(LeagueFormDto leagueFormDto) {
        League league = mapper.apply(leagueFormDto);

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

}
