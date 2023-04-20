package com.kjb.dongbu.Repository.Store;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import com.kjb.dongbu.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberStore {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member member) {
        MemberJpo memberJpo = new MemberJpo(member);
        memberRepository.save(memberJpo);
    }

    public Member findById(long m_code) {
        Optional<MemberJpo> optionalMemberJpo = memberRepository.findById(m_code);
        return optionalMemberJpo.map(MemberJpo::toDomain).orElse(null);
    }

    public List<Member> findMembersByName(String name) {
        List<MemberJpo> memberJpos = memberRepository.findByNameContains(name);
        return MemberJpo.toDomains(memberJpos);
    }

    public void deleteById(long m_code) {
        memberRepository.deleteById(m_code);
    }
}
