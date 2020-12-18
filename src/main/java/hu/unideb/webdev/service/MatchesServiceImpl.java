package hu.unideb.webdev.service;

import hu.unideb.webdev.dao.MatchesDao;
import hu.unideb.webdev.exceptions.ExistingMatchException;
import hu.unideb.webdev.exceptions.UnknownMatchException;
import hu.unideb.webdev.exceptions.UnknownTeamException;
import hu.unideb.webdev.model.Matches;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesDao matchesDao;

    @Override
    public Collection<Matches> getAllMatches() {
        return matchesDao.readAll();
    }

    @Override
    public void recordMatch(Matches match) throws UnknownTeamException, ExistingMatchException {
        matchesDao.createMatch(match);
    }

    @Override
    public void updateMatch(Matches match) throws UnknownMatchException {
        matchesDao.updateMatch(match);
    }

    @Override
    public void deleteMatch(String id) throws UnknownMatchException {
        matchesDao.deleteMatch(id);
    }
}
