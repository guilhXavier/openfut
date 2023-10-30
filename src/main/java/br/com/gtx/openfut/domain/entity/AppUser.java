package br.com.gtx.openfut.domain.entity;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Builder
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" })
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreatedDate
    private Instant createdDate;

    private Integer overall;

    @OneToMany(mappedBy = "owner")
    private List<League> ownedLeagues;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "current_team", referencedColumnName = "id")
    @JsonIgnore
    private Team currentTeam;

}
