/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "time_slot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeSlotEntity.findAll", query = "SELECT t FROM TimeSlotEntity t"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotId", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotId = :timeSlotId"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotNumber", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotNumber = :timeSlotNumber"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotStartTimeHours", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotStartTimeHours = :timeSlotStartTimeHours"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotStartTimeMinutes", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotStartTimeMinutes = :timeSlotStartTimeMinutes"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotEndTimeHours", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotEndTimeHours = :timeSlotEndTimeHours"),
    @NamedQuery(name = "TimeSlotEntity.findByTimeSlotEndTimeMinutes", query = "SELECT t FROM TimeSlotEntity t WHERE t.timeSlotEndTimeMinutes = :timeSlotEndTimeMinutes")})
public class TimeSlotEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_slot_id")
    private Integer timeSlotId;
    @Size(max = 45)
    @Column(name = "time_slot_number")
    private String timeSlotNumber;
    @Column(name = "time_slot_start_time_hours")
    private Integer timeSlotStartTimeHours;
    @Column(name = "time_slot_start_time_minutes")
    private Integer timeSlotStartTimeMinutes;
    @Column(name = "time_slot_end_time_hours")
    private Integer timeSlotEndTimeHours;
    @Column(name = "time_slot_end_time_minutes")
    private Integer timeSlotEndTimeMinutes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeSlotId")
    private List<TimeTableEntity> timeTableEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeSlotId")
    private List<ClassScheduleEntity> classScheduleEntityList;

    public TimeSlotEntity() {
    }

    public TimeSlotEntity(Integer timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Integer getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Integer timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getTimeSlotNumber() {
        return timeSlotNumber;
    }

    public void setTimeSlotNumber(String timeSlotNumber) {
        this.timeSlotNumber = timeSlotNumber;
    }

    public Integer getTimeSlotStartTimeHours() {
        return timeSlotStartTimeHours;
    }

    public void setTimeSlotStartTimeHours(Integer timeSlotStartTimeHours) {
        this.timeSlotStartTimeHours = timeSlotStartTimeHours;
    }

    public Integer getTimeSlotStartTimeMinutes() {
        return timeSlotStartTimeMinutes;
    }

    public void setTimeSlotStartTimeMinutes(Integer timeSlotStartTimeMinutes) {
        this.timeSlotStartTimeMinutes = timeSlotStartTimeMinutes;
    }

    public Integer getTimeSlotEndTimeHours() {
        return timeSlotEndTimeHours;
    }

    public void setTimeSlotEndTimeHours(Integer timeSlotEndTimeHours) {
        this.timeSlotEndTimeHours = timeSlotEndTimeHours;
    }

    public Integer getTimeSlotEndTimeMinutes() {
        return timeSlotEndTimeMinutes;
    }

    public void setTimeSlotEndTimeMinutes(Integer timeSlotEndTimeMinutes) {
        this.timeSlotEndTimeMinutes = timeSlotEndTimeMinutes;
    }

    @XmlTransient
    public List<TimeTableEntity> getTimeTableEntityList() {
        return timeTableEntityList;
    }

    public void setTimeTableEntityList(List<TimeTableEntity> timeTableEntityList) {
        this.timeTableEntityList = timeTableEntityList;
    }

    @XmlTransient
    public List<ClassScheduleEntity> getClassScheduleEntityList() {
        return classScheduleEntityList;
    }

    public void setClassScheduleEntityList(List<ClassScheduleEntity> classScheduleEntityList) {
        this.classScheduleEntityList = classScheduleEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeSlotId != null ? timeSlotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeSlotEntity)) {
            return false;
        }
        TimeSlotEntity other = (TimeSlotEntity) object;
        if ((this.timeSlotId == null && other.timeSlotId != null) || (this.timeSlotId != null && !this.timeSlotId.equals(other.timeSlotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.TimeSlotEntity[ timeSlotId=" + timeSlotId + " ]";
    }
    
}
