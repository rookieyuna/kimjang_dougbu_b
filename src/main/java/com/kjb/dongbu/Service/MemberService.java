package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Model.Vo.YesOrNo;
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

        member.setRegidate(System.currentTimeMillis());
        member.setStatus(YesOrNo.Yes);

        memberStore.save(member);
        return member.getMemCode();
    }

    public List<Member> findMembersByName (String name) {
        return memberStore.findMembersByName(name);
    }

    public void modifyMember (MemberUdo memberUdo){
        Member member = memberStore.findById(memberUdo.getMemCode());

        if (member.getMemCode() == memberUdo.getMemCode()) {
            member.setName(memberUdo.getName());
            member.setPhone(memberUdo.getPhone());
            member.setStatus(memberUdo.getStatus());
        }
        memberStore.save(member);
    }

    public void removeMember (long m_code) {
        memberStore.deleteById(m_code);
    }
}
