package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.MatchStats;
import lombok.Data;

@Data
public class ExistingMatchStatException extends Exception {
    private MatchStats matchStat;

    public ExistingMatchStatException(MatchStats matchStat){this.matchStat=matchStat;}

    public ExistingMatchStatException(String message, MatchStats matchStat){
        super(message);
        this.matchStat=matchStat;
    }

    public ExistingMatchStatException(String message){super(message);}
}
