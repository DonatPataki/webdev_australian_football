package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.MatchesEntity;
import hu.unideb.webdev.dao.entity.TeamsEntity;
import hu.unideb.webdev.dao.repository.MatchesRepository;
import hu.unideb.webdev.dao.repository.TeamRepository;
import hu.unideb.webdev.exceptions.ExistingMatchException;
import hu.unideb.webdev.exceptions.UnknownMatchException;
import hu.unideb.webdev.exceptions.UnknownTeamException;
import hu.unideb.webdev.model.Matches;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchesDaoImpl implements MatchesDao {
    private final MatchesRepository matchesRepository;
    private final TeamRepository teamRepository;

    @Override
    public void createMatch(Matches match) throws UnknownTeamException, ExistingMatchException {
        MatchesEntity matchesEntity;

        checkMatch(match.getId());

        matchesEntity = MatchesEntity.builder().id(match.getId()).season(match.getSeason()).round(match.getRound())
                .team1(queryTeam(match.getTid1())).team2(queryTeam(match.getTid2())).team1Location(match.getTid1_loc())
                .team2Location(match.getTid2_loc()).startDate(match.getStart_dt()).venue(match.getVenue())
                .attendants(match.getAtt()).margin(match.getMargin())
                .winnerScore(match.getWin_score()).winnerTeam(match.getWin_tid()).winnerLocation(match.getWin_loc())
                .loserScore(match.getLose_score()).loserLocation(match.getLose_loc()).loserTeam(match.getLose_tid())
                .homeTeam(match.getH_tid()).homeScore(match.getH_score())
                .homeQ1Goals(match.getH_q1g()).homeQ2Goals(match.getH_q2g()).homeQ3Goals(match.getH_q3g()).homeQ4Goals(match.getH_q4g()).homeExtraTimeGoals(match.getH_etg())
                .homeQ1Behinds(match.getH_q1b()).homeQ2Behinds(match.getH_q2b()).homeQ3Behinds(match.getH_q3b()).homeQ4Behinds(match.getH_q4b()).homeExtraTimeBehinds(match.getH_etb())
                .awayTeam(match.getA_tid()).awayScore(match.getA_score())
                .awayQ1Goals(match.getA_q1g()).awayQ2Goals(match.getA_q2g()).awayQ3Goals(match.getA_q3g()).awayQ4Goals(match.getA_q4g()).awayExtraTimeGoals(match.getA_etg())
                .awayQ1Behinds(match.getA_q1b()).awayQ2Behinds(match.getA_q2b()).awayQ3Behinds(match.getA_q3b()).awayQ4Behinds(match.getA_q4b()).awayExtraTimeBehinds(match.getA_etb())
                .target(match.getTarget())
                .build();
        log.info("MatchesEntity: {}",matchesEntity);
        try {
            matchesRepository.save(matchesEntity);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    protected void checkMatch(String matchId) throws ExistingMatchException {
        Optional<MatchesEntity> matchesEntity = matchesRepository.findById(matchId);

        if (matchesEntity.isPresent()){
            throw new ExistingMatchException(String.format("Match found %s",matchId));
        }
    }

    protected TeamsEntity queryTeam(int teamId) throws UnknownTeamException{
        Optional<TeamsEntity> teamsEntity = teamRepository.findById(teamId);

        if (teamsEntity.isEmpty()){
            throw new UnknownTeamException(String.format("Team Not Found %d",teamId));
        }

        return teamsEntity.get();
    }

    @Override
    public Collection<Matches> readAll() {
        log.info("Listing all match");
        return StreamSupport.stream(matchesRepository.findAll().spliterator(),false)
                .map(entity -> new Matches(
                        entity.getId(),
                        entity.getSeason(),
                        entity.getRound(),
                        entity.getTeam1().getId(),
                        entity.getTeam2().getId(),
                        entity.getTeam1Location(),
                        entity.getTeam2Location(),
                        entity.getStartDate(),
                        entity.getVenue(),
                        entity.getAttendants(),
                        entity.getMargin(),
                        entity.getWinnerScore(),
                        entity.getWinnerTeam(),
                        entity.getWinnerLocation(),
                        entity.getLoserScore(),
                        entity.getLoserLocation(),
                        entity.getLoserTeam(),
                        entity.getHomeTeam(),
                        entity.getHomeScore(),
                        entity.getHomeQ1Goals(),
                        entity.getHomeQ2Goals(),
                        entity.getHomeQ3Goals(),
                        entity.getHomeQ4Goals(),
                        entity.getHomeExtraTimeGoals(),
                        entity.getHomeQ1Behinds(),
                        entity.getHomeQ2Behinds(),
                        entity.getHomeQ3Behinds(),
                        entity.getHomeQ4Behinds(),
                        entity.getHomeExtraTimeBehinds(),
                        entity.getAwayTeam(),
                        entity.getAwayScore(),
                        entity.getAwayQ1Goals(),
                        entity.getAwayQ2Goals(),
                        entity.getAwayQ3Goals(),
                        entity.getAwayQ4Goals(),
                        entity.getAwayExtraTimeGoals(),
                        entity.getAwayQ1Behinds(),
                        entity.getAwayQ2Behinds(),
                        entity.getAwayQ3Behinds(),
                        entity.getAwayQ4Behinds(),
                        entity.getAwayExtraTimeBehinds(),
                        entity.getTarget()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateMatch(Matches match) throws UnknownMatchException{
        Optional<MatchesEntity> matchesEntity = StreamSupport.stream(matchesRepository.findAll().spliterator(),false).filter(
                entity -> entity.getId().equals(match.getId())
        ).findAny();
        if (matchesEntity.isEmpty()){
            throw new UnknownMatchException(String.format("Match Not Found %s",match));
        }else{
            matchesEntity.get().setTeam1Location(match.getTid1_loc());
            matchesEntity.get().setTeam2Location(match.getTid2_loc());
            matchesEntity.get().setStartDate(match.getStart_dt());
            matchesEntity.get().setVenue(match.getVenue());
            matchesEntity.get().setAttendants(match.getAtt());
            matchesEntity.get().setMargin(match.getMargin());
            matchesEntity.get().setWinnerScore(match.getWin_score());
            matchesEntity.get().setWinnerTeam(match.getWin_tid());
            matchesEntity.get().setWinnerLocation(match.getWin_loc());
            matchesEntity.get().setLoserScore(match.getLose_score());
            matchesEntity.get().setLoserLocation(match.getLose_loc());
            matchesEntity.get().setLoserTeam(match.getLose_tid());
            matchesEntity.get().setHomeTeam(match.getH_tid());
            matchesEntity.get().setHomeScore(match.getH_score());
            matchesEntity.get().setHomeQ1Goals(match.getH_q1g());
            matchesEntity.get().setHomeQ2Goals(match.getH_q2g());
            matchesEntity.get().setHomeQ3Goals(match.getH_q3g());
            matchesEntity.get().setHomeQ4Goals(match.getH_q4g());
            matchesEntity.get().setHomeExtraTimeGoals(match.getH_etg());
            matchesEntity.get().setHomeQ1Behinds(match.getH_q1b());
            matchesEntity.get().setHomeQ2Behinds(match.getH_q2b());
            matchesEntity.get().setHomeQ3Behinds(match.getH_q3b());
            matchesEntity.get().setHomeQ4Behinds(match.getH_q4b());
            matchesEntity.get().setHomeExtraTimeBehinds(match.getH_etb());
            matchesEntity.get().setAwayTeam(match.getA_tid());
            matchesEntity.get().setAwayScore(match.getA_score());
            matchesEntity.get().setAwayQ1Goals(match.getA_q1g());
            matchesEntity.get().setAwayQ2Goals(match.getA_q2g());
            matchesEntity.get().setAwayQ3Goals(match.getA_q3g());
            matchesEntity.get().setAwayQ4Goals(match.getA_q4g());
            matchesEntity.get().setAwayExtraTimeGoals(match.getA_etg());
            matchesEntity.get().setAwayQ1Behinds(match.getA_q1b());
            matchesEntity.get().setAwayQ2Behinds(match.getA_q2b());
            matchesEntity.get().setAwayQ3Behinds(match.getA_q3b());
            matchesEntity.get().setAwayQ4Behinds(match.getA_q4b());
            matchesEntity.get().setAwayExtraTimeBehinds(match.getA_etb());
            matchesEntity.get().setTarget(match.getTarget());
        }
        try {
            matchesRepository.save(matchesEntity.get());
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteMatch(String id) throws UnknownMatchException {
        Optional<MatchesEntity> matchesEntity = StreamSupport.stream(matchesRepository.findAll().spliterator(),false).filter(
                entity -> id.equals(entity.getId())
        ).findAny();
        if (matchesEntity.isEmpty()){
            throw new UnknownMatchException(String.format("Match with this ID Not Found %s",id));
        }
        matchesRepository.delete(matchesEntity.get());
    }
}
