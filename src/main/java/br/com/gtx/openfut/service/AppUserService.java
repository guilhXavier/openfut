package br.com.gtx.openfut.service;

import java.util.Optional;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.dto.AppUserFormDTO;

public interface AppUserService {

    AppUser save(AppUserFormDTO appUserFormDTO);

    Optional<AppUser> findByName(String name);

    void updateUser(AppUserFormDTO appUserFormDTO);

}
