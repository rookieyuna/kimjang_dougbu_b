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
public class HistoryCdo {
    private long memCode; // 회원코드
    private long rdate; // 예약날짜
    private YesOrNo prepaidYn; // 선납여부
    private int prepaidPrice; // 선납금액
    private YesOrNo debtYn; // 외상여부
    private long dtCode; // 외상코드
    private YesOrNo cardYn; // 카드여부
}
