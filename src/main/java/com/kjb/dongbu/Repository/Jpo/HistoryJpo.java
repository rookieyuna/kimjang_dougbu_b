package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="history")
public class HistoryJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long h_code;
    @Column(nullable = false)
    private long m_code;
    @Column(nullable = false)
    private long sdate;
    @Column(nullable = false)
    private long edate;
    @Column(nullable = true)
    private long rdate;
    @Column(length = 2, nullable = true) // Default: "N"
    private String prepaid_yn;
    @Column(nullable = true)
    private int prepaid_price;
    @Column(length = 2, nullable = true) // Default: "N"
    private String debt_yn;
    @Column(nullable = false)
    private long d_code;
    @Column(length = 2, nullable = false) // Default: "N"
    private String card_yn;
    @Column(nullable = false)
    private int total;

    public HistoryJpo(History history) {
        BeanUtils.copyProperties(history, this);
        this.sdate = System.currentTimeMillis();
        this.prepaid_yn = "N";
        this.debt_yn = "N";
        this.card_yn = "N";
    }

    public History toDomain() {
        History history = new History();
        BeanUtils.copyProperties(this, history);
        return history;
    }

    public static List<History> toDomains(List<HistoryJpo> historyJpos) {
        return historyJpos.stream().map(HistoryJpo::toDomain).collect(Collectors.toList());
    }
}
