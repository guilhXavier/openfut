package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.dto.CourtFormDto;
import br.com.gtx.openfut.service.CourtService;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/court")
@AllArgsConstructor
public class CourtController {

    private final CourtService courtService;

    @PostMapping
    public void save(@RequestBody CourtFormDto entity) {
        courtService.save(entity);
    }

    @PatchMapping
    public void update(@RequestBody CourtFormDto courtFormDto) {
        courtService.update(courtFormDto);
    }

    @GetMapping
    public ResponseEntity<Iterable<Court>> findAll() {
        return ResponseEntity.ok(courtService.findAll());
    }

    @GetMapping("/team")
    public ResponseEntity<Court> getCourtByTeam(@RequestParam Long teamId) {
        Optional<Court> courtByTeam = courtService.getCourtByTeam(teamId);

        if (courtByTeam.isPresent()) {
            return ResponseEntity.ok(courtByTeam.get());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/id")
    public ResponseEntity<Court> getCourtById(@RequestParam Long teamId) {
        Optional<Court> courtById = courtService.getCourtByTeam(teamId);

        if (courtById.isPresent()) {
            return ResponseEntity.ok(courtById.get());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/name")
    public ResponseEntity<Court> getCourtByName(@RequestParam String name) {
        Optional<Court> courtByName = courtService.getCourtByName(name);

        if (courtByName.isPresent()) {
            return ResponseEntity.ok(courtByName.get());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/address")
    public ResponseEntity<Court> getCourtByAddress(@RequestParam String address) {
        Optional<Court> courtByAddress = courtService.getCourtByAddress(address);

        if (courtByAddress.isPresent()) {
            return ResponseEntity.ok(courtByAddress.get());
        }

        return ResponseEntity.badRequest().body(null);
    }
}
