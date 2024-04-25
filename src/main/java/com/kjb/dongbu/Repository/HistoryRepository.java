package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.HistoryJpo;
import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HistoryRepository extends JpaRepository<HistoryJpo, String> {
    List<HistoryJpo> findBySdateBetween(long sdate1, long sdate2);
    // 20240425 추가
    List<HistoryJpo> findBySdateBetween_Member_Products_MemCode(long sdate1, long sdate2, long memCode);
    List<HistoryJpo> findBySdate(long sdate);
    List<HistoryJpo> findByMemCode(long memCode);
}
