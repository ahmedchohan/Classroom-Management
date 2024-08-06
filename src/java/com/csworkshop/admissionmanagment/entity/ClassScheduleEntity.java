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
@Table(name = "class_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassScheduleEntity.findAll", query = "SELECT c FROM ClassScheduleEntity c"),
    @NamedQuery(name = "ClassScheduleEntity.findByClassScheduleId", query = "SELECT c FROM ClassScheduleEntity c WHERE c.classScheduleId = :classScheduleId")})
public class ClassScheduleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "class_schedule_id")
    private Integer classScheduleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classScheduleId")
    private List<ClassHeldEntity> classHeldEntityList;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private DepartmentEntity departmentId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private RoomEntity roomId;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private SubjectEntity subjectId;
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false)
    private TeacherEntity teacherId;
    @JoinColumn(name = "time_slot_id", referencedColumnName = "time_slot_id")
    @ManyToOne(optional = false)
    private TimeSlotEntity timeSlotId;

    public ClassScheduleEntity() {
    }

    public ClassScheduleEntity(Integer classScheduleId) {
        this.classScheduleId = classScheduleId;
    }

    public Integer getClassScheduleId() {
        return classScheduleId;
    }

    public void setClassScheduleId(Integer classScheduleId) {
        this.classScheduleId = classScheduleId;
    }

    @XmlTransient
    public List<ClassHeldEntity> getClassHeldEntityList() {
        return classHeldEntityList;
    }

    public void setClassHeldEntityList(List<ClassHeldEntity> classHeldEntityList) {
        this.classHeldEntityList = classHeldEntityList;
    }

    public DepartmentEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentEntity departmentId) {
        this.departmentId = departmentId;
    }

    public RoomEntity getRoomId() {
        return roomId;
    }

    public void setRoomId(RoomEntity roomId) {
        this.roomId = roomId;
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
        hash += (classScheduleId != null ? classScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassScheduleEntity)) {
            return false;
        }
        ClassScheduleEntity other = (ClassScheduleEntity) object;
        if ((this.classScheduleId == null && other.classScheduleId != null) || (this.classScheduleId != null && !this.classScheduleId.equals(other.classScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.ClassScheduleEntity[ classScheduleId=" + classScheduleId + " ]";
    }
    
}
