package br.com.gtx.openfut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.Team;

public interface CourtRepository extends CrudRepository<Court, Long> {

    List<Court> findByHomeTeams(List<Team> homeTeams);

    List<Court> findByName(String name);

    List<Court> findByAddress(String address);

}
