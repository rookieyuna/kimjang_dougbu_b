package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Cdo.MemberCdo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
        BeanUtils.copyProperties(memberCdo,this);
    }
}
