/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csworkshop.admissionmanagment.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arahman
 */
@Entity
@Table(name = "time_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeTableEntity.findAll", query = "SELECT t FROM TimeTableEntity t"),
    @NamedQuery(name = "TimeTableEntity.findByTimeTableId", query = "SELECT t FROM TimeTableEntity t WHERE t.timeTableId = :timeTableId"),
    @NamedQuery(name = "TimeTableEntity.findByWeekDay", query = "SELECT t FROM TimeTableEntity t WHERE t.weekDay = :weekDay")})
public class TimeTableEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "time_table_id")
    private Integer timeTableId;
    @Size(max = 45)
    @Column(name = "week_day")
    private String weekDay;
    @JoinColumn(name = "class_held_class_schedule_id", referencedColumnName = "class_held_id")
    @ManyToOne(optional = false)
    private ClassHeldEntity classHeldClassScheduleId;
    @JoinColumn(name = "room_room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private RoomEntity roomRoomId;
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    @ManyToOne(optional = false)
    private SemesterEntity semesterId;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SubjectEntity subjectId;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private TeacherEntity teacherId;
    @JoinColumn(name = "time_slot_id", referencedColumnName = "time_slot_id")
    @ManyToOne(optional = false)
    private TimeSlotEntity timeSlotId;

    public TimeTableEntity() {
    }

    public TimeTableEntity(Integer timeTableId) {
        this.timeTableId = timeTableId;
    }

    public Integer getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(Integer timeTableId) {
        this.timeTableId = timeTableId;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public ClassHeldEntity getClassHeldClassScheduleId() {
        return classHeldClassScheduleId;
    }

    public void setClassHeldClassScheduleId(ClassHeldEntity classHeldClassScheduleId) {
        this.classHeldClassScheduleId = classHeldClassScheduleId;
    }

    public RoomEntity getRoomRoomId() {
        return roomRoomId;
    }

    public void setRoomRoomId(RoomEntity roomRoomId) {
        this.roomRoomId = roomRoomId;
    }

    public SemesterEntity getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(SemesterEntity semesterId) {
        this.semesterId = semesterId;
    }

    public SubjectEntity getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(SubjectEntity subjectId) {
        this.subjectId = subjectId;
    }

    public TeacherEntity getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherEntity teacherId) {
        this.teacherId = teacherId;
    }

    public TimeSlotEntity getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(TimeSlotEntity timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeTableId != null ? timeTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeTableEntity)) {
            return false;
        }
        TimeTableEntity other = (TimeTableEntity) object;
        if ((this.timeTableId == null && other.timeTableId != null) || (this.timeTableId != null && !this.timeTableId.equals(other.timeTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.TimeTableEntity[ timeTableId=" + timeTableId + " ]";
    }
    
}
