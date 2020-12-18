package hu.unideb.webdev.service;

import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.MatchStats;

import java.util.Collection;

public interface MatchStatsService {
    Collection<MatchStats> getAllMatchStats();

    void recordMatchStat(MatchStats matchStat) throws UnknownMatchException, UnknownPlayerException, UnknownTeamException, ExistingMatchStatException;
    void updateMatchStat(MatchStats matchStat) throws UnknownMatchStatException, UnknownTeamException, UnknownMatchException, UnknownPlayerException;
    void deleteMatchStat(String mid, int pid) throws UnknownMatchStatException, UnknownPlayerException, UnknownMatchException;
}
