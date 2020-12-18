package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.Teams;
import lombok.Data;

@Data
public class ExistingTeamException extends Exception {
    private Teams team;

    public ExistingTeamException(Teams team){this.team=team;}

    public ExistingTeamException(String message, Teams team){
        super(message);
        this.team=team;
    }

    public ExistingTeamException(String message){super(message);}
}
