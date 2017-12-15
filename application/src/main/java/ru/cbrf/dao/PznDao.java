package ru.cbrf.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Pzn;

@Transactional
@Repository
public interface PznDao extends CrudRepository<Pzn, String> {

  List<Pzn> findAll();
}