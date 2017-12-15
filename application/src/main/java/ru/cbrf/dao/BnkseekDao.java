package ru.cbrf.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Bnkseek;

@Transactional
@Repository
public interface BnkseekDao extends JpaRepository<Bnkseek, String> {

    @Query(value = "select b.* from bnk.Bnkseek b\n" +
        "    left JOIN bnk.reg r on r.rgn=b.rgn \n" +
        "where rkc like ('%' || ?1 ||'%') " +
        "and r.name like ('%' || ?2 || '%') " +
        "and pzn like ('%' || ?3 || '%') " +
        "\n-- #pageable\n",
        countQuery = "select count(*) from bnk.Bnkseek b\n" +
            "    left JOIN bnk.reg r on r.rgn=b.rgn\n" +
            "where rkc like ('%' || ?1 ||'%') " +
            "and r.name like ('%' || ?2 || '%') " +
            "and pzn like ('%' || ?3 || '%') ",
        nativeQuery = true
    )
    Page<Bnkseek> findAllByRkcAndRegAndPzn(String rkc, String reg, String pzn, Pageable pageable);

//    Page<Bnkseek> findAll(Pageable pageable);
} 