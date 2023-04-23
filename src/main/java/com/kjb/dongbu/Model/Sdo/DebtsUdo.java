package com.kjb.dongbu.Model.Sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebtsUdo {
    private long dtCode; // 외상코드
    private long memCode; // 회원코드
    private long paybackDate; // 갚은 날짜
    private int price; // 외상액
}
