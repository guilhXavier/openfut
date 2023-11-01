package br.com.gtx.openfut.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.dto.AppUserFormDTO;
import br.com.gtx.openfut.mapper.AppUserMapper;
import br.com.gtx.openfut.repository.AppUserRepository;
import br.com.gtx.openfut.service.AppUserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    private final AppUserMapper appUserMapper;

    @Override
    public AppUser save(AppUserFormDTO appUserFormDTO) {

        AppUser appUser = appUserMapper.apply(appUserFormDTO);

        return appUserRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> findByName(String name) {

        Optional<AppUser> findByName = appUserRepository.findByName(name);

        return findByName;
    }
}
