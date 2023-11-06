package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.service.TeamService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    String healthCheck() {
        return "OK.";
    }

}
