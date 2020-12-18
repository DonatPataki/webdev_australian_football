package hu.unideb.webdev.dao.repository;

import hu.unideb.webdev.dao.entity.MatchStatsEntity;
import hu.unideb.webdev.dao.entity.MatchStatsId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchStatsRepository extends CrudRepository<MatchStatsEntity, MatchStatsId> {
    Optional<MatchStatsEntity> findById(MatchStatsId id);
}
