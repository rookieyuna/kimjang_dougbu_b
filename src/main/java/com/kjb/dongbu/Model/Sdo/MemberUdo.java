package com.kjb.dongbu.Model.Sdo;

import com.kjb.dongbu.Model.Vo.YesOrNo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUdo {
    private long memCode;
    private String name;
    private String phone;
    private YesOrNo Status;
}
