package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="member")
public class MemberJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long m_code;
    private String address;
    private String name;
    private String phone;
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

    public static MemberJpo Sample() {
        return new MemberJpo(1,"가산동 112", "홍길동","010-1234-5678", "Y", System.currentTimeMillis());
    }
}
