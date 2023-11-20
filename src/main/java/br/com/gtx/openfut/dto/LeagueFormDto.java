package br.com.gtx.openfut.dto;

import java.util.List;

import br.com.gtx.openfut.domain.LeagueState;
import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.domain.entity.Team;

public record LeagueFormDto(Long id, String name, LeagueState leagueState, AppUser owner, List<Match> matches,
        List<Team> teams) {
}
