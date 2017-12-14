package ru.cbrf.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Reg;

@Transactional
@Repository
public interface RegDao extends CrudRepository<Reg, String> {
}