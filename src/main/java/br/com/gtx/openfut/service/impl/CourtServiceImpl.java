package br.com.gtx.openfut.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.CourtFormDto;
import br.com.gtx.openfut.mapper.CourtMapper;
import br.com.gtx.openfut.repository.CourtRepository;
import br.com.gtx.openfut.repository.TeamRepository;
import br.com.gtx.openfut.service.CourtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;

    private final TeamRepository teamRepository;

    private final CourtMapper mapper;

    @Override
    public void save(CourtFormDto courtFormDto) {
        Court court = mapper.apply(courtFormDto);

        courtRepository.save(court);
    }

    @Override
    public void update(CourtFormDto courtFormDto) {
        Court court = mapper.apply(courtFormDto);

        courtRepository.save(court);
    }

    @Override
    public Iterable<Court> findAll() {
        return courtRepository.findAll();
    }

    @Override
    public Optional<Court> getCourtByTeam(Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);

        List<Team> asList = Arrays.asList(team.get());

        return Optional.of(courtRepository.findByHomeTeams(asList).get(0));
    }

    @Override
    public Optional<Court> getCourtById(Long courtId) {
        return courtRepository.findById(courtId);
    }

    @Override
    public Optional<Court> getCourtByName(String name) {
        return Optional.of(courtRepository.findByName(name).get(0));
    }

    @Override
    public Optional<Court> getCourtByAddress(String address) {
        return Optional.of(courtRepository.findByAddress(address).get(0));
    }

}
