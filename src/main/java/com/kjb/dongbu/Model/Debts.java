package com.kjb.dongbu.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Debts {

    @Id
    private String dtCode; // 외상코드
    private long memCode; // 회원코드
    private long paybackDate; // 갚은 날짜
    private int price; // 외상액

}
