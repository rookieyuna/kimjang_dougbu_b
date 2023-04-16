package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.HistoryJpo;
import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HistoryRepository extends JpaRepository<HistoryJpo, Long> {
    List<HistoryJpo> findByBetweenDates(long sdate, long edate);
    List<HistoryJpo> findBySdate(long sdate);
    List<HistoryJpo> findByMcode(long mcode);
}
