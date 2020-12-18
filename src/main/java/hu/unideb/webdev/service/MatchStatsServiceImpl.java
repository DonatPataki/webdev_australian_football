package hu.unideb.webdev.service;

import hu.unideb.webdev.dao.MatchStatsDao;
import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.MatchStats;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchStatsServiceImpl implements MatchStatsService {

    private final MatchStatsDao matchStatsDao;

    @Override
    public Collection<MatchStats> getAllMatchStats() {
        return matchStatsDao.readAll();
    }

    @Override
    public void recordMatchStat(MatchStats matchStat) throws UnknownMatchException, UnknownPlayerException, UnknownTeamException, ExistingMatchStatException {
        matchStatsDao.createMatchStat(matchStat);
    }

    @Override
    public void updateMatchStat(MatchStats matchStat) throws UnknownMatchStatException, UnknownTeamException, UnknownMatchException, UnknownPlayerException {
        matchStatsDao.updateMatchStat(matchStat);
    }

    @Override
    public void deleteMatchStat(String mid, int pid) throws UnknownMatchStatException, UnknownPlayerException, UnknownMatchException {
        matchStatsDao.deleteMatchStat(mid,pid);
    }
}
