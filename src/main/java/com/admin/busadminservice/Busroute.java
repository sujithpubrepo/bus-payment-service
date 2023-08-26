package com.admin.busadminservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "busroutes")
public class Busroute {
    @Id
    @Column(name = "busid", nullable = false, length = 10)
    private String busid;

    @Column(name = "source", nullable = false, length = 20)
    private String source;

    @Column(name = "destination", nullable = false, length = 20)
    private String destination;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "totalseats", nullable = false)
    private Integer totalseats;

    @Column(name = "busname", nullable = false, length = 20)
    private String busname;

    @Column(name = "starttime", nullable = false)
    private LocalTime starttime;

    @Column(name = "endtime", nullable = false)
    private LocalTime endtime;

}