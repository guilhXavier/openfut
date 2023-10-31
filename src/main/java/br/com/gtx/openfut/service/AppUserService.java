package br.com.gtx.openfut.service;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.dto.AppUserFormDTO;

public interface AppUserService {

    AppUser save(AppUserFormDTO appUserFormDTO);

    AppUser findByName(String name);

}
