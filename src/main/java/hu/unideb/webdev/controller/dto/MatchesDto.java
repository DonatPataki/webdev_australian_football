package hu.unideb.webdev.controller.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MatchesDto {

    private String id;
    private int season;
    private String round;
    private int tid1;
    private int tid2;
    private String tid1_loc;
    private String tid2_loc;
    private Timestamp start_dt;
    private String venue;
    private Integer att;
    private Integer margin;
    private Integer win_score;
    private Integer win_tid;
    private String win_loc;
    private Integer lose_score;
    private String lose_loc;
    private Integer lose_tid;

    private Integer h_tid;
    private Integer h_score;
    private Integer h_q1g;
    private Integer h_q2g;
    private Integer h_q3g;
    private Integer h_q4g;
    private Integer h_etg;
    private Integer h_q1b;
    private Integer h_q2b;
    private Integer h_q3b;
    private Integer h_q4b;
    private Integer h_etb;

    private Integer a_tid;
    private Integer a_score;
    private Integer a_q1g;
    private Integer a_q2g;
    private Integer a_q3g;
    private Integer a_q4g;
    private Integer a_etg;
    private Integer a_q1b;
    private Integer a_q2b;
    private Integer a_q3b;
    private Integer a_q4b;
    private Integer a_etb;

    private Integer target;
}
