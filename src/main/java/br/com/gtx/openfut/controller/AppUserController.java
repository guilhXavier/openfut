package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.dto.AppUserFormDTO;
import br.com.gtx.openfut.service.AppUserService;
import lombok.AllArgsConstructor;

@RestController("/user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("/health")
    String healthCheck() {
        return "OK.";
    }

    @PostMapping("/register")
    void registerUser(@RequestBody final AppUserFormDTO appUserFormDTO) {
        appUserService.save(appUserFormDTO);
        return;
    }

}
