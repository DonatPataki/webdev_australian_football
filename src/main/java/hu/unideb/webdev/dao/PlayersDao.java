package hu.unideb.webdev.dao;

import hu.unideb.webdev.exceptions.ExistingPlayerException;
import hu.unideb.webdev.exceptions.UnknownPlayerException;
import hu.unideb.webdev.model.Players;

import java.util.Collection;

public interface PlayersDao {

    void createPlayer(Players player);

    Collection<Players> readAll();

    void updatePlayer(Players player) throws UnknownPlayerException;

    void deletePlayer(int id) throws UnknownPlayerException;
}
