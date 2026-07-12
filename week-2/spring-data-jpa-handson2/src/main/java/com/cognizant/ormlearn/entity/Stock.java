package com.cognizant.ormlearn.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code", length = 10)
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "st_date")
    private Date date;

    @Column(name = "st_open", precision = 10, scale = 2)
    private BigDecimal open;

    @Column(name = "st_close", precision = 10, scale = 2)
    private BigDecimal close;

    @Column(name = "st_volume")
    private Long volume;

    public Stock() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("| %-7s | %tF | %7.2f | %8.2f | %10d |", 
            code, date, open, close, volume);
    }
}
