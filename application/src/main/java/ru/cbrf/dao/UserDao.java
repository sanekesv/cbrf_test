package ru.cbrf.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import ru.cbrf.model.Bnkseek;

@Transactional
public interface UserDao extends CrudRepository<Bnkseek, String> {

    List<Bnkseek> findByNamen(String namen);
} 