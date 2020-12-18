package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.Teams;
import lombok.Data;

@Data
public class UnknownTeamException extends Exception {
    private Teams team;

    public UnknownTeamException(Teams team){this.team=team;}

    public UnknownTeamException(String message, Teams team){
        super(message);
        this.team=team;
    }

    public UnknownTeamException(String message){super(message);}
}
