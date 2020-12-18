package hu.unideb.webdev.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="teams", schema = "AustralianFootball")
public class TeamsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int id;

    @Column(name = "tname")
    private String teamName;

}
