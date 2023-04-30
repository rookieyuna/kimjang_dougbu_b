package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.DebtsJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DebtsRepository extends JpaRepository<DebtsJpo, String> {
    List<DebtsJpo> findByPaybackDate(long paybackDate);
    List<DebtsJpo> findByMemCode(long memCode);
}
