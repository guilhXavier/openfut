package br.com.gtx.openfut.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
        Optional<Court> findById = courtRepository.findById(courtFormDto.id());

        Predicate<String> isNotEmpty = (value) -> !value.isEmpty();

        if (findById.isPresent()) {
            Court updatedCourt = findById.get();

            Optional.ofNullable(courtFormDto.name())
                    .filter(isNotEmpty)
                    .ifPresent(updatedCourt::setName);

            Optional.ofNullable(courtFormDto.address())
                    .filter(isNotEmpty)
                    .ifPresent(updatedCourt::setAddress);

            courtRepository.save(updatedCourt);
        }

    }

    @Override
    public Iterable<Court> findAll() {
        return courtRepository.findAll();
    }

    @Override
    public Iterable<Court> getCourtByTeam(Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);

        List<Team> asList = Arrays.asList(team.get());

        return courtRepository.findByHomeTeamsIn(asList);
    }

    @Override
    public Optional<Court> getCourtById(Long courtId) {
        return courtRepository.findById(courtId);
    }

    @Override
    public Iterable<Court> getCourtByName(String name) {
        return courtRepository.findByNameContains(name);
    }

    @Override
    public Iterable<Court> getCourtByAddress(String address) {
        return courtRepository.findByAddressContains(address);
    }

    @Override
    public void setHomeCourt(Long teamId, Long courtId) {
        Team team = teamRepository.findById(teamId).get();

        Court court = courtRepository.findById(courtId).get();

        team.setHomeCourt(court);

        teamRepository.save(team);

    }

    @Override
    public void delete(Long courtId) {
        courtRepository.deleteById(courtId);
    }

}
