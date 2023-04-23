package com.kjb.dongbu.Model.Sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryUdo {
    private long htCode; //접수코드
    private long memCode; // 회원코드
    private long edate; //찾아간날짜
    private long rdate; // 예약날짜
    private String prepaidYn; // 선납여부
    private int prepaidPrice; // 선납금액
    private String debtYn; // 외상여부
    private long dtCode; // 외상코드
    private String cardYn; // 카드여부
    private int total; // 총금액
}
