package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.Players;
import lombok.Data;

@Data
public class UnknownPlayerException extends Exception {
    private Players player;

    public UnknownPlayerException(Players player){this.player=player;}

    public UnknownPlayerException(String message, Players player){
        super(message);
        this.player=player;
    }

    public UnknownPlayerException(String message){super(message);}
}
