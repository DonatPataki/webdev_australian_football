package hu.unideb.webdev.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="matches", schema = "AustralianFootball")
public class MatchesEntity {

    @Id
    @Column(name="mid")
    private String id;

    @Column(name="season")
    private int season;

    private String round;

    @ManyToOne
    @JoinColumn(name = "tid1")
    private TeamsEntity team1;

    @ManyToOne
    @JoinColumn(name = "tid2")
    private TeamsEntity team2;

    @Column(name = "tid1_loc")
    private String team1Location;

    @Column(name = "tid2_loc")
    private String team2Location;

    @Column(name = "start_dt")
    private Timestamp startDate;

    private String venue;

    @Column(name = "att")
    private Integer attendants;

    private Integer margin;

    @Column(name = "win_score")
    private Integer winnerScore;

    @Column(name = "win_tid")
    private Integer winnerTeam;

    @Column(name = "win_loc")
    private String winnerLocation;

    @Column(name = "lose_score")
    private Integer loserScore;

    @Column(name = "lose_tid")
    private Integer loserTeam;

    @Column(name = "lose_loc")
    private String loserLocation;

    @Column(name = "h_tid")
    private Integer homeTeam;

    @Column(name = "h_score")
    private Integer homeScore;

    @Column(name = "h_q1g")
    private Integer homeQ1Goals;

    @Column(name = "h_q2g")
    private Integer homeQ2Goals;

    @Column(name = "h_q3g")
    private Integer homeQ3Goals;

    @Column(name = "h_q4g")
    private Integer homeQ4Goals;

    @Column(name = "h_etg")
    private Integer homeExtraTimeGoals;

    @Column(name = "h_q1b")
    private Integer homeQ1Behinds;

    @Column(name = "h_q2b")
    private Integer homeQ2Behinds;

    @Column(name = "h_q3b")
    private Integer homeQ3Behinds;

    @Column(name = "h_q4b")
    private Integer homeQ4Behinds;

    @Column(name = "h_etb")
    private Integer homeExtraTimeBehinds;

    @Column(name = "a_tid")
    private Integer awayTeam;

    @Column(name = "a_score")
    private Integer awayScore;

    @Column(name = "a_q1g")
    private Integer awayQ1Goals;

    @Column(name = "a_q2g")
    private Integer awayQ2Goals;

    @Column(name = "a_q3g")
    private Integer awayQ3Goals;

    @Column(name = "a_q4g")
    private Integer awayQ4Goals;

    @Column(name = "a_etg")
    private Integer awayExtraTimeGoals;

    @Column(name = "a_q1b")
    private Integer awayQ1Behinds;

    @Column(name = "a_q2b")
    private Integer awayQ2Behinds;

    @Column(name = "a_q3b")
    private Integer awayQ3Behinds;

    @Column(name = "a_q4b")
    private Integer awayQ4Behinds;

    @Column(name = "a_etb")
    private Integer awayExtraTimeBehinds;

    @Column(name = "target")
    private Integer target;

}
