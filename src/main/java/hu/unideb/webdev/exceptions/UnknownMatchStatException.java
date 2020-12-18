package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.MatchStats;
import lombok.Data;

@Data
public class UnknownMatchStatException extends Exception{
    private MatchStats matchStats;

    public UnknownMatchStatException(MatchStats matchStats){this.matchStats=matchStats;}

    public UnknownMatchStatException(String message, MatchStats matchStats){
        super(message);
        this.matchStats=matchStats;
    }

    public UnknownMatchStatException(String message){super(message);}
}
