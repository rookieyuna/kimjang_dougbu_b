package com.kjb.dongbu.Model.Sdo;

import com.kjb.dongbu.Model.Vo.YesOrNo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryUdo {
    private String htCode; //접수코드
    private long edate; //찾아간날짜
    private long rdate; // 예약날짜
    private int prepaidPrice; // 선납금액
    private long dtCode; // 외상코드
    private int paybackPrice; //외상지불액
    private YesOrNo cardYn; // 카드여부
}
