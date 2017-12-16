package ru.cbrf.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cbrf.model.Bnkseek;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BnkseekDao extends JpaRepository<Bnkseek, String> {

    @Query(value = "select b.* from bnk.Bnkseek b\n" +
        "    left JOIN bnk.reg r on r.rgn=b.rgn \n" +
        "where rkc like ('%' || ?1 ||'%') " +
            "and (r.name like ('%' || ?2 || '%') or (b.rgn is null and ?2='')) " +
        "and pzn like ('%' || ?3 || '%') " +
        "\n-- #pageable\n",
        countQuery = "select count(*) from bnk.Bnkseek b\n" +
            "    left JOIN bnk.reg r on r.rgn=b.rgn\n" +
            "where rkc like ('%' || ?1 ||'%') " +
                "and (r.name like ('%' || ?2 || '%') or (b.rgn is null and ?2='')) " +
            "and pzn like ('%' || ?3 || '%') ",
        nativeQuery = true
    )
    Page<Bnkseek> findAllByRkcAndRegAndPzn(String rkc, String reg, String pzn, Pageable pageable);

    @Query(value = "select cast((max(cast(newnum as INTEGER))+1) as VARCHAR(9)) from bnk.bnkseek", nativeQuery = true)
    String getNextId();

//    Page<Bnkseek> findAll(Pageable pageable);
} 