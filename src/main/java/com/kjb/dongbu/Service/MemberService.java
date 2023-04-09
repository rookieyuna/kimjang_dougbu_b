package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Cdo.MemberCdo;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Repository.Store.MemberStore;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberStore memberStore;

    public MemberService(MemberStore memberStore){
        this.memberStore = memberStore;
    }

    public long registerMember(MemberCdo memberCdo){
        Member member = new Member(memberCdo);

        memberStore.save(member);
        return member.getM_code();
    }
}
