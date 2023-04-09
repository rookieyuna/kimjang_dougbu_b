package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<MemberJpo, Long> {
    public List<MemberJpo> findByName(String name);
}

//https://goddaehee.tistory.com/209
