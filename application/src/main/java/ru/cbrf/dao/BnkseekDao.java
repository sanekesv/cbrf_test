package ru.cbrf.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Bnkseek;

@Transactional
@Repository
public interface BnkseekDao extends CrudRepository<Bnkseek, String> {

    List<Bnkseek> findByNamen(String namen);
} 