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
    private long h_code;
    private long m_code;
    private long sdate;
    private long edate;
    private long rdate;
    private String prepaid_yn;
    private int prepaid_price;
    private String debt_yn;
    private long d_code;
    private String card_yn;
    private int total;

    public History(HistoryCdo historyCdo){
        BeanUtils.copyProperties(historyCdo, this);
    }
}
