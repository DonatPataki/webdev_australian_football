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
@Table(name="players", schema = "AustralianFootball")
public class PlayersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private int id;

    @Column(name = "dob")
    private Timestamp dateOfBirth;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

}
