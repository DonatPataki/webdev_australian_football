package hu.unideb.webdev.dao.repository;

import hu.unideb.webdev.dao.entity.TeamsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<TeamsEntity, Integer> {
    @Override
    Optional<TeamsEntity> findById(Integer id);
}
