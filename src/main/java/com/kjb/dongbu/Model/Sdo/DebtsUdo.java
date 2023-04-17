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
    private long d_code; // 외상코드
    private long m_code; // 회원코드
    private long payback_date; // 갚은 날짜
    private int price; // 외상액
}
