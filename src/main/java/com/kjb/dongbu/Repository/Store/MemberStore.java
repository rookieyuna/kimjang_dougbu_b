package com.kjb.dongbu.Repository.Store;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import com.kjb.dongbu.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStore {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member member) {
        MemberJpo memberJpo = new MemberJpo(member);
        memberRepository.save(memberJpo);
    }
}
