package hu.unideb.webdev.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlayersDto {
    private int id;
    private String dob;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;

}
