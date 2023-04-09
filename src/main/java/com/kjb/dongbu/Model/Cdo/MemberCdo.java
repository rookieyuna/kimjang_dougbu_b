package com.kjb.dongbu.Model.Cdo;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberCdo {
    private String address;
    private String name;
    private String phone;
    private String status;
}
