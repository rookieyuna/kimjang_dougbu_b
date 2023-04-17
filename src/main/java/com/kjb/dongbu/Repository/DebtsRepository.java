package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.DebtsJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DebtsRepository extends JpaRepository<DebtsJpo, Long> {
    List<DebtsJpo> findByPaybackdate(long paybackdate);
    List<DebtsJpo> findByMcode(long mcode);
}
