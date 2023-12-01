package br.com.gtx.openfut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gtx.openfut.domain.entity.Court;
import br.com.gtx.openfut.dto.CourtFormDto;
import br.com.gtx.openfut.service.CourtService;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping
    public void delete(@RequestParam Long courtId) {
        courtService.delete(courtId);
    }

    @PatchMapping("/home-court")
    public void setHomeCourt(@RequestParam Long teamId, @RequestParam Long courtId) {
        courtService.setHomeCourt(teamId, courtId);
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
    public ResponseEntity<Iterable<Court>> getCourtByTeam(@RequestParam Long teamId) {
        Iterable<Court> courtByTeam = courtService.getCourtByTeam(teamId);

        return ResponseEntity.ok(courtByTeam);

    }

    @GetMapping("/id")
    public ResponseEntity<Court> getCourtById(@RequestParam Long courtId) {
        Optional<Court> courtById = courtService.getCourtById(courtId);

        System.out.println(courtById.isPresent());
        if (courtById.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(courtById.get());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/name")
    public ResponseEntity<Iterable<Court>> getCourtByName(@RequestParam String name) {
        Iterable<Court> courtByName = courtService.getCourtByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(courtByName);

    }

    @GetMapping("/address")
    public ResponseEntity<Iterable<Court>> getCourtByAddress(@RequestParam String address) {
        Iterable<Court> courtByAddress = courtService.getCourtByAddress(address);

        return ResponseEntity.status(HttpStatus.OK).body(courtByAddress);
    }
}
