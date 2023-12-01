package br.com.gtx.openfut.service;

import java.util.Optional;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.dto.CourtFormDto;

public interface CourtService {

    void save(CourtFormDto courtFormDto);

    void update(CourtFormDto courtFormDto);

    void delete(Long courtId);

    void setHomeCourt(Long teamId, Long courtId);

    Iterable<Court> findAll();

    Iterable<Court> getCourtByTeam(Long teamId);

    Optional<Court> getCourtById(Long courtId);

    Iterable<Court> getCourtByName(String name);

    Iterable<Court> getCourtByAddress(String address);

}
