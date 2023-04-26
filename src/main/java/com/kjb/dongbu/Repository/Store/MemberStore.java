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

    public List<Member> findAll() {
        List<MemberJpo> memberJpos = memberRepository.findAll();
        return MemberJpo.toDomains(memberJpos);
    }

    public Member findById(long memCode) {
        Optional<MemberJpo> optionalMemberJpo = memberRepository.findById(memCode);
        return optionalMemberJpo.map(MemberJpo::toDomain).orElse(null);
    }

    public List<Member> findMembersByName(String name) {
        List<MemberJpo> memberJpos = memberRepository.findByNameContains(name);
        return MemberJpo.toDomains(memberJpos);
    }

    public void deleteById(long memCode) {
        memberRepository.deleteById(memCode);
    }
}
