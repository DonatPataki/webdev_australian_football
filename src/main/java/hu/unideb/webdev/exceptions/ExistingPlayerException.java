package hu.unideb.webdev.exceptions;


import hu.unideb.webdev.model.Players;
import lombok.Data;

@Data
public class ExistingPlayerException extends Exception{
    private Players player;

    public ExistingPlayerException(Players player){this.player=player;}

    public ExistingPlayerException(String message, Players player){
        super(message);
        this.player=player;
    }

    public ExistingPlayerException(String message){super(message);}
}
