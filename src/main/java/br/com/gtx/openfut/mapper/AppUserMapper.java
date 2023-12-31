package br.com.gtx.openfut.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.dto.AppUserFormDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppUserMapper implements Function<AppUserFormDTO, AppUser> {

    @Override
    public AppUser apply(final AppUserFormDTO appUserFormDTO) {
        return AppUser.builder()
                .name(appUserFormDTO.name())
                .password(appUserFormDTO.password())
                .overall(appUserFormDTO.overall())
                .build();
    }
}
