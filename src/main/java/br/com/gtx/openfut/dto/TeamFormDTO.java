package br.com.gtx.openfut.dto;

import java.util.List;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.League;

public record TeamFormDTO(Long id, String name, Court homeCourt, List<AppUser> players, List<League> leagues) {
}
