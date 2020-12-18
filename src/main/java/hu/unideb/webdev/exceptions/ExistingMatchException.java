package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.Matches;
import lombok.Data;

@Data
public class ExistingMatchException extends Exception {
    private Matches match;

    public ExistingMatchException(Matches match){this.match=match;}

    public ExistingMatchException(String message, Matches match){
        super(message);
        this.match=match;
    }

    public ExistingMatchException(String message){super(message);}
}
