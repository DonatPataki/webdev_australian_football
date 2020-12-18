package hu.unideb.webdev.dao;

import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.MatchStats;

import java.util.Collection;

public interface MatchStatsDao {
    void createMatchStat(MatchStats matchStats) throws UnknownMatchException, UnknownPlayerException, UnknownTeamException, ExistingMatchStatException;

    Collection<MatchStats> readAll();

    void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatException, UnknownTeamException, UnknownMatchException, UnknownPlayerException;

    void deleteMatchStat(String mid, int pid) throws UnknownMatchStatException, UnknownMatchException, UnknownPlayerException;
}
