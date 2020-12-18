package hu.unideb.webdev.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MatchStatsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "mid")
    private MatchesEntity mid;

    @ManyToOne
    @JoinColumn(name = "pid")
    private PlayersEntity pid;
}
