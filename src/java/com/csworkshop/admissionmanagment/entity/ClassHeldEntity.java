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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "class_held")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassHeldEntity.findAll", query = "SELECT c FROM ClassHeldEntity c"),
    @NamedQuery(name = "ClassHeldEntity.findByClassHeldId", query = "SELECT c FROM ClassHeldEntity c WHERE c.classHeldId = :classHeldId"),
    @NamedQuery(name = "ClassHeldEntity.findByActualStartTimeHour", query = "SELECT c FROM ClassHeldEntity c WHERE c.actualStartTimeHour = :actualStartTimeHour"),
    @NamedQuery(name = "ClassHeldEntity.findByActualStartTimeMinutes", query = "SELECT c FROM ClassHeldEntity c WHERE c.actualStartTimeMinutes = :actualStartTimeMinutes"),
    @NamedQuery(name = "ClassHeldEntity.findByActualEndTimeHours", query = "SELECT c FROM ClassHeldEntity c WHERE c.actualEndTimeHours = :actualEndTimeHours"),
    @NamedQuery(name = "ClassHeldEntity.findByActualEndTimeMinutes", query = "SELECT c FROM ClassHeldEntity c WHERE c.actualEndTimeMinutes = :actualEndTimeMinutes"),
    @NamedQuery(name = "ClassHeldEntity.findByClassHeldStatus", query = "SELECT c FROM ClassHeldEntity c WHERE c.classHeldStatus = :classHeldStatus")})
public class ClassHeldEntity implements Serializable {
    public static final boolean CLASS_HELD_STATUS_HELD=true;
    public static final boolean CLASS_HELD_STATUS_NOT_HELD=false;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "class_held_id")
    private Integer classHeldId;
    @Column(name = "actual_start_time_hour")
    private Integer actualStartTimeHour;
    @Column(name = "actual_start_time_minutes")
    private Integer actualStartTimeMinutes;
    @Column(name = "actual_end_time_hours")
    private Integer actualEndTimeHours;
    @Column(name = "actual_end_time_minutes")
    private Integer actualEndTimeMinutes;
    @Column(name = "class_held_status")
    private Boolean classHeldStatus;
    @JoinColumn(name = "class_schedule_id", referencedColumnName = "class_schedule_id")
    @ManyToOne(optional = false)
    private ClassScheduleEntity classScheduleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classHeldClassScheduleId")
    private List<TimeTableEntity> timeTableEntityList;

    public ClassHeldEntity() {
    }

    public ClassHeldEntity(Integer classHeldId) {
        this.classHeldId = classHeldId;
    }

    public Integer getClassHeldId() {
        return classHeldId;
    }

    public void setClassHeldId(Integer classHeldId) {
        this.classHeldId = classHeldId;
    }

    public Integer getActualStartTimeHour() {
        return actualStartTimeHour;
    }

    public void setActualStartTimeHour(Integer actualStartTimeHour) {
        this.actualStartTimeHour = actualStartTimeHour;
    }

    public Integer getActualStartTimeMinutes() {
        return actualStartTimeMinutes;
    }

    public void setActualStartTimeMinutes(Integer actualStartTimeMinutes) {
        this.actualStartTimeMinutes = actualStartTimeMinutes;
    }

    public Integer getActualEndTimeHours() {
        return actualEndTimeHours;
    }

    public void setActualEndTimeHours(Integer actualEndTimeHours) {
        this.actualEndTimeHours = actualEndTimeHours;
    }

    public Integer getActualEndTimeMinutes() {
        return actualEndTimeMinutes;
    }

    public void setActualEndTimeMinutes(Integer actualEndTimeMinutes) {
        this.actualEndTimeMinutes = actualEndTimeMinutes;
    }

    public Boolean getClassHeldStatus() {
        return classHeldStatus;
    }

    public void setClassHeldStatus(Boolean classHeldStatus) {
        this.classHeldStatus = classHeldStatus;
    }

    public ClassScheduleEntity getClassScheduleId() {
        return classScheduleId;
    }

    public void setClassScheduleId(ClassScheduleEntity classScheduleId) {
        this.classScheduleId = classScheduleId;
    }

    @XmlTransient
    public List<TimeTableEntity> getTimeTableEntityList() {
        return timeTableEntityList;
    }

    public void setTimeTableEntityList(List<TimeTableEntity> timeTableEntityList) {
        this.timeTableEntityList = timeTableEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classHeldId != null ? classHeldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassHeldEntity)) {
            return false;
        }
        ClassHeldEntity other = (ClassHeldEntity) object;
        if ((this.classHeldId == null && other.classHeldId != null) || (this.classHeldId != null && !this.classHeldId.equals(other.classHeldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.ClassHeldEntity[ classHeldId=" + classHeldId + " ]";
    }
    
}
