package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Sdo.DebtsCdo;
import com.kjb.dongbu.Model.Sdo.HistoryCdo;
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
    private long dtCode; // 외상코드
    private long memCode; // 회원코드
    private long paybackDate; // 갚은 날짜
    private int price; // 외상액

    public Debts(DebtsCdo debtsCdo){
        BeanUtils.copyProperties(debtsCdo, this);
    }
}
