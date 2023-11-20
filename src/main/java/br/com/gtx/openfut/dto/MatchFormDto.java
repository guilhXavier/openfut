package br.com.gtx.openfut.dto;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.domain.entity.Team;

public record MatchFormDto(Long id, Integer homeScore, Integer awayScore, Team homeTeam, Team awayTeam, League league,
        Court court) {
}
