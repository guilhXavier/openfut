package br.com.gtx.openfut.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.domain.entity.League;

public interface LeagueRepository extends CrudRepository<League, Long> {

    Iterable<League> findByTeams_id(Long id);

    Iterable<League> findByOwner(AppUser owner);

}
