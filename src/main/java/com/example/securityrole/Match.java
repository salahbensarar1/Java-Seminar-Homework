package com.example.securityrole;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private java.sql.Date mdate;
    private java.sql.Time startsat;
    private BigDecimal ticketprice;
    private String mtype;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Entry> entries;

    public Integer getId() {
        return id;
    }

    public Date getMdate() {
        return mdate;
    }

    public Time getStartsat() {
        return startsat;
    }

    public BigDecimal getTicketprice() {
        return ticketprice;
    }

    public String getMtype() {
        return mtype;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public void setStartsat(Time startsat) {
        this.startsat = startsat;
    }

    public void setTicketprice(BigDecimal ticketprice) {
        this.ticketprice = ticketprice;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }
    // Getters and setters

}
