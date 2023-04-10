package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Repository.Store.MemberStore;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Member> findMembersByName (String name) {
        return memberStore.findMembersByName(name);
    }

    public void modifyMember (MemberUdo memberUdo){
        Member member = memberStore.findById(memberUdo.getM_code());

        if (member.getM_code() != 0) {
            member.setName(memberUdo.getName());
            member.setPhone(memberUdo.getPhone());
        }
        memberStore.save(member);
    }
}
