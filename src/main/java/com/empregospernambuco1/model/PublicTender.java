package com.empregospernambuco1.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PublicTender extends Opportunity {

    private String caption;
    private String examinationBoard;
    private BigDecimal valueExame;
    @Enumerated(value = EnumType.STRING)
    private Level level;
    private String office;
    private Date deadlineSubscripton;
    private Integer amount;
    private String linkNotice;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getExaminationBoard() {
        return examinationBoard;
    }

    public void setExaminationBoard(String examinationBoard) {
        this.examinationBoard = examinationBoard;
    }

    public BigDecimal getValueExame() {
        return valueExame;
    }

    public void setValueExame(BigDecimal valueExame) {
        this.valueExame = valueExame;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Date getDeadlineSubscripton() {
        return deadlineSubscripton;
    }

    public void setDeadlineSubscripton(Date deadlineSubscripton) {
        this.deadlineSubscripton = deadlineSubscripton;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLinkNotice() {
        return linkNotice;
    }

    public void setLinkNotice(String linkNotice) {
        this.linkNotice = linkNotice;
    }
}
