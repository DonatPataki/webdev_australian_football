package hu.unideb.webdev.service;

import hu.unideb.webdev.dao.PlayersDao;
import hu.unideb.webdev.exceptions.UnknownPlayerException;
import hu.unideb.webdev.model.Players;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    private final PlayersDao playersDao;

    @Override
    public Collection<Players> getAllPlayers() {
        return playersDao.readAll();
    }

    @Override
    public void recordPlayer(Players player) {
        playersDao.createPlayer(player);
    }

    @Override
    public void updatePlayer(Players player) throws UnknownPlayerException {
        playersDao.updatePlayer(player);
    }

    @Override
    public void deletePlayer(int id) throws UnknownPlayerException {
        playersDao.deletePlayer(id);
    }
}
