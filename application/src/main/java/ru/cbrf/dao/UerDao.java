package ru.cbrf.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Uer;

@Transactional
@Repository
public interface UerDao extends CrudRepository<Uer, String> {

  List<Uer> findAll();
}