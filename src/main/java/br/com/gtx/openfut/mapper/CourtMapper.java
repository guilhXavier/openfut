package br.com.gtx.openfut.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.dto.CourtFormDto;

@Component
public class CourtMapper implements Function<CourtFormDto, Court> {

    @Override
    public Court apply(CourtFormDto t) {
        return Court.builder()
                .id(t.id())
                .address(t.address())
                .name(t.name())
                .build();
    }

}
