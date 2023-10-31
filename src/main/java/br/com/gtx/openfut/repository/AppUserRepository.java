package br.com.gtx.openfut.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.gtx.openfut.domain.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByName(final String name);

}
