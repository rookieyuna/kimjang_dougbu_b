package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Vo.YesOrNo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="history")
public class HistoryJpo {

    @Id
    private String htCode;
    @Column(nullable = false)
    private long memCode;
    @Column(nullable = false)
    private long sdate;
    @Column(nullable = false)
    private long edate;
    @Column(nullable = true)
    private long rdate;
    @Column(nullable = true)
    private int prepaidPrice;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private YesOrNo debtYn;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private YesOrNo cardYn;
    @Column(nullable = false)
    private int total;

    //20240424 작업중...
    @ManyToOne //JOIN
    @JoinColumn(name = "memCode") //FK를 써준다.
    private MemberJpo memberJpo;


    public HistoryJpo(History history) {
        BeanUtils.copyProperties(history, this);
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
