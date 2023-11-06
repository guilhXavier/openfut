package br.com.gtx.openfut.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Optional<Team> findByName(final String name);

}
