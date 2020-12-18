package hu.unideb.webdev.dao;

import hu.unideb.webdev.exceptions.ExistingTeamException;
import hu.unideb.webdev.exceptions.UnknownTeamException;
import hu.unideb.webdev.model.Teams;

import java.util.Collection;

public interface TeamsDao {
    void createTeam(Teams team);

    Collection<Teams> readAll();

    void updateTeam(Teams team) throws UnknownTeamException;

    void deleteTeam(int id) throws UnknownTeamException;
}
