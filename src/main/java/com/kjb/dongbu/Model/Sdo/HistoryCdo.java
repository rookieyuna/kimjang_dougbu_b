package com.kjb.dongbu.Model.Sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCdo {
    private long m_code; // 회원코드
    private long rdate; // 예약날짜
    private String prepaid_yn; // 선납여부
    private int prepaid_price; // 선납금액
    private String debt_yn; // 외상여부
    private String d_code; // 외상코드
    private String card_yn; // 카드여부
}
