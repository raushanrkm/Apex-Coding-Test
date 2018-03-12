package com.apex.coding.test.dbbean;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long serialNo;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private String description;

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "serialNo=" + serialNo +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
