package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Sdo.MemberCdo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    private long m_code;
    private String address;
    private String name;
    private String phone;
    private String status;
    private long regidate;

    public Member(MemberCdo memberCdo){
        BeanUtils.copyProperties(memberCdo, this);
    }
}
