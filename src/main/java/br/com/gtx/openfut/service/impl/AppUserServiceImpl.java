package br.com.gtx.openfut.service.impl;

import java.util.Optional;
import java.util.function.Predicate;

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

    @Override
    public void updateUser(AppUserFormDTO appUserFormDTO) {
        Optional<AppUser> user = appUserRepository.findByName(appUserFormDTO.name());

        Predicate<String> isNotEmpty = (value) -> !value.isEmpty();

        if (user.isPresent()) {
            AppUser updatedUser = user.get();

            Optional.ofNullable(appUserFormDTO.name())
                    .filter(isNotEmpty)
                    .ifPresent(updatedUser::setName);

            Optional.ofNullable(appUserFormDTO.password())
                    .filter(isNotEmpty)
                    .ifPresent(updatedUser::setPassword);

            Optional.ofNullable(appUserFormDTO.overall())
                    .filter((overall) -> overall >= 0)
                    .ifPresent(updatedUser::setOverall);

            appUserRepository.save(updatedUser);
        }

    }

}
