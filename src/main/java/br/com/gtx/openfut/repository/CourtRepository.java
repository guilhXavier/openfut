package br.com.gtx.openfut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.domain.entity.Team;

public interface CourtRepository extends CrudRepository<Court, Long> {

    List<Court> findByHomeTeamsIn(List<Team> homeTeams);

    List<Court> findByNameContains(String name);

    List<Court> findByAddressContains(String address);

}
