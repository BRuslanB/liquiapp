package kz.bitlab.springbootpro.liquibaseApp.liquiapp.repository;

import kz.bitlab.springbootpro.liquibaseApp.liquiapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

}