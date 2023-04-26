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
    private int prepaidPrice; // 선납금액
    private YesOrNo cardYn; // 카드여부

    private ProductCdo[] productCdos;
}
