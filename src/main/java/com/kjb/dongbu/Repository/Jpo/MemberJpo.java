package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="member")
public class MemberJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long m_code;
    @Column(length = 200, nullable = false)
    private String address;
    @Column(length = 20, nullable = true)
    private String name;
    @Column(length = 20, nullable = true)
    private String phone;
    @Column(length = 2)
    private String status;
    private long regidate;

    public MemberJpo(Member member) {
        BeanUtils.copyProperties(member, this);
    }

    public Member toDomain() {
        Member member = new Member();
        BeanUtils.copyProperties(this, member);
        return member;
    }

    public static List<Member> toDomains(List<MemberJpo> memberJpos) {
        return memberJpos.stream().map(MemberJpo::toDomain).collect(Collectors.toList());
    }

    public static MemberJpo Sample() {
        return new MemberJpo(1,"가산동 112", "홍길동","010-1234-5678", "Y", System.currentTimeMillis());
    }
}
