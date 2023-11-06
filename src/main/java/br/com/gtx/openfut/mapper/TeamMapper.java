package br.com.gtx.openfut.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.Team;
import br.com.gtx.openfut.dto.TeamFormDTO;

@Component
public class TeamMapper implements Function<TeamFormDTO, Team> {

    @Override
    public Team apply(final TeamFormDTO teamFormDTO) {
        return Team.builder()
                .id(teamFormDTO.id())
                .name(teamFormDTO.name())
                .homeCourt(teamFormDTO.homeCourt())
                .players(teamFormDTO.players())
                .leagues(teamFormDTO.leagues())
                .build();

    }
}
