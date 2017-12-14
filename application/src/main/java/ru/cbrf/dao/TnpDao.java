package ru.cbrf.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Tnp;

@Transactional
@Repository
public interface TnpDao extends CrudRepository<Tnp, String> {
}