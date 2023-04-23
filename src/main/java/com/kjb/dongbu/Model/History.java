package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Sdo.HistoryCdo;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class History {

    @Id
    private long htCode;
    private long memCode;
    private long sdate;
    private long edate;
    private long rdate;
    private String prepaidYn;
    private int prepaidPrice;
    private String debtYn;
    private long dtCode;
    private String cardYn;
    private int total;

    public History(HistoryCdo historyCdo){
        BeanUtils.copyProperties(historyCdo, this);
    }
}
