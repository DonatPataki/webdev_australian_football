package hu.unideb.webdev.dao.repository;

import hu.unideb.webdev.dao.entity.MatchesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchesRepository extends CrudRepository<MatchesEntity, String> {
    @Override
    Optional<MatchesEntity> findById(String id);
}
