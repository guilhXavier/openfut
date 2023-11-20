package br.com.gtx.openfut.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.Match;
import br.com.gtx.openfut.dto.MatchFormDto;

@Component
public class MatchMapper implements Function<MatchFormDto, Match> {

    @Override
    public Match apply(MatchFormDto matchFormDto) {
        return Match.builder()
                .id(matchFormDto.id())
                .homeScore(matchFormDto.homeScore())
                .awayScore(matchFormDto.awayScore())
                .homeTeam(matchFormDto.homeTeam())
                .awayTeam(matchFormDto.awayTeam())
                .league(matchFormDto.league())
                .court(matchFormDto.court())
                .build();
    }

}
