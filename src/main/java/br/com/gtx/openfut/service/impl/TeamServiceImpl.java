package br.com.gtx.openfut.service.impl;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.TeamFormDTO;
import br.com.gtx.openfut.mapper.TeamMapper;
import br.com.gtx.openfut.repository.AppUserRepository;
import br.com.gtx.openfut.repository.TeamRepository;
import br.com.gtx.openfut.service.TeamService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final AppUserRepository appUserRepository;

    private final TeamMapper teamMapper;

    @Override
    public Team save(TeamFormDTO teamFormDTO) {

        Team team = teamMapper.apply(teamFormDTO);

        return teamRepository.save(team);
    }

    @Override
    public void update(TeamFormDTO teamFormDTO) {
        Optional<Team> team = teamRepository.findById(teamFormDTO.id());

        Predicate<String> isNotEmpty = (value) -> !value.isEmpty();

        if (team.isPresent()) {
            Team updatedTeam = team.get();

            Optional.ofNullable(teamFormDTO.name())
                    .filter(isNotEmpty)
                    .ifPresent(updatedTeam::setName);

            Optional.ofNullable(teamFormDTO.homeCourt())
                    .filter((value) -> value != null)
                    .ifPresent(updatedTeam::setHomeCourt);

            Optional.ofNullable(teamFormDTO.players())
                    .filter((value) -> value != null)
                    .ifPresent(updatedTeam::setPlayers);

            Optional.ofNullable(teamFormDTO.leagues())
                    .filter((value) -> value != null)
                    .ifPresent(updatedTeam::setLeagues);

            teamRepository.save(updatedTeam);
        }
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Iterable<Team> findByNameContains(String name) {
        return teamRepository.findByNameContains(name);
    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Iterable<AppUser> getPlayersByTeamId(Long id) {
        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent()) {
            return team.get().getPlayers();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void addPlayer(Long teamId, Long playerId) {
        Optional<AppUser> user = appUserRepository.findById(playerId);
        Optional<Team> team = teamRepository.findById(teamId);

        if (user.isPresent() && team.isPresent()) {
            Team updatedTeam = team.get();

            updatedTeam.getPlayers().add(user.get());

            teamRepository.save(updatedTeam);
        }
    }

}
