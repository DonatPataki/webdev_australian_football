package hu.unideb.webdev.controller.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MatchStatsDto {
    private String mid;
    private int pid;
    private int tid;
    private String loc;
    private Integer KI;
    private Integer MK;
    private Integer HB;
    private Integer DI;
    private Integer GL;
    private Integer BH;
    private Integer HO;
    private Integer TK;
    private Integer RB;
    private Integer IF;
    private Integer CL;
    private Integer CG;
    private Integer FF;
    private Integer FA;
    private Integer BR;
    private Integer CP;
    private Integer UP;
    private Integer CM;
    private Integer MI;
    private Float oneP;
    private Integer BO;
    private Integer GA;
    private Float PP;
}
