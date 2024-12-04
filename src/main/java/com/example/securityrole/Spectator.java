package com.example.securityrole;
import jakarta.persistence.*;

import java.security.KeyStore;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "spectators")
public class Spectator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sname;
    private Boolean male;
    private Boolean haspass;

    @OneToMany(mappedBy = "spectator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Entry> entries;

    public Integer getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public Boolean getMale() {
        return male;
    }

    public Boolean getHaspass() {
        return haspass;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public void setHaspass(Boolean haspass) {
        this.haspass = haspass;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }
}
