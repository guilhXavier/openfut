package br.com.gtx.openfut.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.dto.AppUserFormDTO;
import br.com.gtx.openfut.dto.AppUserLoginDto;
import br.com.gtx.openfut.service.AppUserService;
import lombok.AllArgsConstructor;

@RestController()
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    void registerUser(@RequestBody final AppUserFormDTO appUserFormDTO) {
        appUserService.save(appUserFormDTO);
        return;
    }

    @PostMapping("/login")
    ResponseEntity<AppUser> loginUser(@RequestBody final AppUserLoginDto appUserLoginDto) {
        Optional<AppUser> findByName = appUserService.findByName(appUserLoginDto.name());

        if (findByName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(findByName.get());
    }

    @PatchMapping("/update")
    void patchUser(@RequestBody final AppUserFormDTO appUserFormDTO) {
        appUserService.updateUser(appUserFormDTO);
    }
}
