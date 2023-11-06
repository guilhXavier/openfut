package br.com.gtx.openfut.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Iterable<Team> findByNameContains(final String name);

}
