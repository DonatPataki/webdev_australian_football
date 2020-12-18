package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.TeamsEntity;
import hu.unideb.webdev.dao.repository.TeamRepository;
import hu.unideb.webdev.exceptions.ExistingTeamException;
import hu.unideb.webdev.exceptions.UnknownTeamException;
import hu.unideb.webdev.model.Teams;
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
public class TeamsDaoImpl implements TeamsDao {

    private final TeamRepository teamRepository;

    @Override
    public void createTeam(Teams team) {
        TeamsEntity teamsEntity;

        teamsEntity = TeamsEntity.builder()
                .teamName(team.getName())
                .build();

        log.info("TeamsEntity: {}",teamsEntity);
        try {
            teamRepository.save(teamsEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public Collection<Teams> readAll() {
        return StreamSupport.stream(teamRepository.findAll().spliterator(),false)
                .map(entity -> new Teams(
                        entity.getId(),
                        entity.getTeamName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateTeam(Teams team) throws UnknownTeamException {
        Optional<TeamsEntity> teamsEntity = teamRepository.findById(team.getId());
        if (teamsEntity.isEmpty()){
            throw new UnknownTeamException(String.format("Team with %s ID does not exist", team.getId()));
        }
        teamsEntity.get().setTeamName(team.getName());

        try {
            teamRepository.save(teamsEntity.get());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteTeam(int id) throws UnknownTeamException {
        Optional<TeamsEntity> teamsEntity = teamRepository.findById(id);
        if (teamsEntity.isEmpty()){
            throw new UnknownTeamException(String.format("Team with %s ID does not exist",id));
        }
        teamRepository.delete(teamsEntity.get());
    }
}
