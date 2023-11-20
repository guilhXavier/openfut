package br.com.gtx.openfut.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.League;
import br.com.gtx.openfut.dto.LeagueFormDto;

@Component
public class LeagueMapper implements Function<LeagueFormDto, League> {

    @Override
    public League apply(LeagueFormDto t) {
        return League.builder()
                .id(t.id())
                .name(t.name())
                .owner(t.owner())
                .matches(t.matches())
                .teams(t.teams())
                .build();
    }

}
