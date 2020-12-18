package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.*;
import hu.unideb.webdev.dao.repository.MatchStatsRepository;
import hu.unideb.webdev.dao.repository.MatchesRepository;
import hu.unideb.webdev.dao.repository.PlayersRepository;
import hu.unideb.webdev.dao.repository.TeamRepository;
import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.MatchStats;
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
public class MatchStatsDaoImpl implements MatchStatsDao{

    private final MatchStatsRepository matchStatsRepository;
    private final MatchesRepository matchesRepository;
    private final TeamRepository teamRepository;
    private final PlayersRepository playersRepository;

    @Override
    public void createMatchStat(MatchStats matchStats) throws UnknownMatchException, UnknownPlayerException, UnknownTeamException, ExistingMatchStatException {
        MatchStatsEntity matchStatsEntity;
        matchStatsEntity= MatchStatsEntity.builder()
                .id(createId(matchStats.getMid(),matchStats.getPid()))
                .team(queryTeam(matchStats.getTid()))
                .location(matchStats.getLoc())
                .kicks(matchStats.getKI())
                .marks(matchStats.getMK())
                .handballs(matchStats.getHB())
                .disposals(matchStats.getDI())
                .goals(matchStats.getGL())
                .behinds(matchStats.getBH())
                .hitOuts(matchStats.getHO())
                .tackles(matchStats.getTK())
                .rebound50s(matchStats.getRB())
                .inside50s(matchStats.getIF())
                .clearances(matchStats.getCL())
                .clangers(matchStats.getCG())
                .freeKicksFor(matchStats.getFF())
                .freeKicksAgainst(matchStats.getFA())
                .brownlowVotes(matchStats.getBR())
                .contestedPossessions(matchStats.getCP())
                .uncontestedPossessions(matchStats.getUP())
                .contestedMarks(matchStats.getCM())
                .marksInside50(matchStats.getMI())
                .onePercenters(matchStats.getOneP())
                .bounces(matchStats.getBO())
                .goalAssist(matchStats.getGA())
                .percentageOfGamePlayed(matchStats.getPP())
                .build();

        log.info("MatchStatsEntity: {}",matchStatsEntity);

        try {
            matchStatsRepository.save(matchStatsEntity);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }
    protected MatchStatsId createId(String mid, int pid) throws UnknownMatchException, UnknownPlayerException, ExistingMatchStatException {
        MatchStatsId id = new MatchStatsId(queryMatch(mid),queryPlayer(pid));
        Optional<MatchStatsEntity> matchStatsEntity = matchStatsRepository.findById(id);

        if (matchStatsEntity.isPresent()){
            throw new ExistingMatchStatException(String.format("MatchStat Found %s",matchStatsEntity));
        }

        return id;
    }

    protected MatchesEntity queryMatch(String mid) throws UnknownMatchException{
        Optional<MatchesEntity> matchesEntity = matchesRepository.findById(mid);

        if (matchesEntity.isEmpty()){
            throw new UnknownMatchException(String.format("Match Not Found ID:%s",mid));
        }

        return matchesEntity.get();

    }
    protected PlayersEntity queryPlayer(int pid) throws UnknownPlayerException{
        Optional<PlayersEntity> playersEntity = playersRepository.findById(pid);

        if (playersEntity.isEmpty()){
            throw new UnknownPlayerException(String.format("Player Not Found ID:%d",pid));
        }

        return playersEntity.get();

    }
    protected TeamsEntity queryTeam(int tid) throws UnknownTeamException{
        Optional<TeamsEntity> teamsEntity = teamRepository.findById(tid);

        if (teamsEntity.isEmpty()){
            throw new UnknownTeamException(String.format("Team Not Found ID:%d",tid));
        }

        return teamsEntity.get();

    }

    @Override
    public Collection<MatchStats> readAll() {
        log.info("Listing all match stats");

        return StreamSupport.stream(matchStatsRepository.findAll().spliterator(),false)
                .map(entity -> new MatchStats(
                        entity.getId().getMid().getId(),
                        entity.getId().getPid().getId(),
                        entity.getTeam().getId(),
                        entity.getLocation(),
                        entity.getKicks(),
                        entity.getMarks(),
                        entity.getHandballs(),
                        entity.getDisposals(),
                        entity.getGoals(),
                        entity.getBehinds(),
                        entity.getHitOuts(),
                        entity.getTackles(),
                        entity.getRebound50s(),
                        entity.getInside50s(),
                        entity.getClearances(),
                        entity.getClangers(),
                        entity.getFreeKicksFor(),
                        entity.getFreeKicksAgainst(),
                        entity.getBrownlowVotes(),
                        entity.getContestedPossessions(),
                        entity.getUncontestedPossessions(),
                        entity.getContestedMarks(),
                        entity.getMarksInside50(),
                        entity.getOnePercenters(),
                        entity.getBounces(),
                        entity.getGoalAssist(),
                        entity.getPercentageOfGamePlayed()
                ))
                .collect(Collectors.toList());

    }

    @Override
    public void updateMatchStat(MatchStats matchStats) throws UnknownMatchStatException, UnknownTeamException, UnknownMatchException, UnknownPlayerException {
        Optional<MatchStatsEntity> matchStatsEntityOp = matchStatsRepository.findById(new MatchStatsId(queryMatch(matchStats.getMid()),queryPlayer(matchStats.getPid())));
        if (matchStatsEntityOp.isEmpty()){
            throw new UnknownMatchStatException(String.format("MatchStat Not Found %s",matchStats));
        }
        MatchStatsEntity matchStatsEntity = matchStatsEntityOp.get();

        matchStatsEntity.setTeam(queryTeam(matchStats.getTid()));
        matchStatsEntity.setLocation(matchStats.getLoc());
        matchStatsEntity.setKicks(matchStats.getKI());
        matchStatsEntity.setMarks(matchStats.getMK());
        matchStatsEntity.setHandballs(matchStats.getHB());
        matchStatsEntity.setDisposals(matchStats.getDI());
        matchStatsEntity.setGoals(matchStats.getGL());
        matchStatsEntity.setBehinds(matchStats.getBH());
        matchStatsEntity.setHitOuts(matchStats.getHO());
        matchStatsEntity.setTackles(matchStats.getTK());
        matchStatsEntity.setRebound50s(matchStats.getRB());
        matchStatsEntity.setInside50s(matchStats.getIF());
        matchStatsEntity.setClearances(matchStats.getCL());
        matchStatsEntity.setClangers(matchStats.getCG());
        matchStatsEntity.setFreeKicksFor(matchStats.getFF());
        matchStatsEntity.setFreeKicksAgainst(matchStats.getFA());
        matchStatsEntity.setBrownlowVotes(matchStats.getBR());
        matchStatsEntity.setContestedPossessions(matchStats.getCP());
        matchStatsEntity.setUncontestedPossessions(matchStats.getUP());
        matchStatsEntity.setContestedMarks(matchStats.getCM());
        matchStatsEntity.setMarksInside50(matchStats.getMI());
        matchStatsEntity.setOnePercenters(matchStats.getOneP());
        matchStatsEntity.setBounces(matchStats.getBO());
        matchStatsEntity.setGoalAssist(matchStats.getGA());
        matchStatsEntity.setPercentageOfGamePlayed(matchStats.getPP());

        try {
            matchStatsRepository.save(matchStatsEntity);
        } catch (Exception e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void deleteMatchStat(String mid, int pid) throws UnknownMatchStatException, UnknownMatchException, UnknownPlayerException {
        MatchStatsId id = new MatchStatsId(queryMatch(mid), queryPlayer(pid));
        Optional<MatchStatsEntity> matchStatsEntity = matchStatsRepository.findById(id);
        if (matchStatsEntity.isEmpty()){
            throw new UnknownMatchStatException(String.format("MatchStat with this ID Not Found %s",id.getMid().getId()+""+id.getPid().getId()));
        }

        matchStatsRepository.delete(matchStatsEntity.get());

    }
}
