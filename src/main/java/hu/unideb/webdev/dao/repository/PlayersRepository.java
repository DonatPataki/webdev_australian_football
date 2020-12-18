package hu.unideb.webdev.dao.repository;

import hu.unideb.webdev.dao.entity.PlayersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayersRepository extends CrudRepository<PlayersEntity, Integer> {

    Optional<PlayersEntity> findById(Integer id);
}
