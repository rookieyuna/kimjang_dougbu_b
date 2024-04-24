package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Vo.YesOrNo;
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
    private long memCode;
    @Column(length = 200, nullable = false)
    private String address;
    @Column(length = 20, nullable = true)
    private String name;
    @Column(length = 20, nullable = true)
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private YesOrNo status;
    private long regidate;

    //20240424 작업중...
    @OneToMany(mappedBy = "member") //mappedBy는 연관관계의 주인을 나타낸다.
    private List<HistoryJpo> historyJpos;

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
        return new MemberJpo(1,"가산동 112", "홍길동","010-1234-5678", YesOrNo.Yes, System.currentTimeMillis());
    }
}
