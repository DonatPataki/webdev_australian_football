package hu.unideb.webdev.service;

import hu.unideb.webdev.exceptions.ExistingMatchException;
import hu.unideb.webdev.exceptions.UnknownMatchException;
import hu.unideb.webdev.exceptions.UnknownTeamException;
import hu.unideb.webdev.model.Matches;

import java.util.Collection;

public interface MatchesService {

    Collection<Matches> getAllMatches();

    void recordMatch(Matches match) throws UnknownTeamException, ExistingMatchException;
    void updateMatch(Matches match) throws UnknownMatchException;
    void deleteMatch(String id) throws UnknownMatchException;

}
