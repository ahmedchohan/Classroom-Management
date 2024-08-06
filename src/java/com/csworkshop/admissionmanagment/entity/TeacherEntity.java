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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherEntity.findAll", query = "SELECT t FROM TeacherEntity t"),
    @NamedQuery(name = "TeacherEntity.findByTeacherId", query = "SELECT t FROM TeacherEntity t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherEntity.findByTeacherName", query = "SELECT t FROM TeacherEntity t WHERE t.teacherName = :teacherName")})
public class TeacherEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Size(max = 45)
    @Column(name = "teacher_name")
    private String teacherName;
    @JoinColumns({
        @JoinColumn(name = "department_id", referencedColumnName = "department_id"),
        @JoinColumn(name = "department_id", referencedColumnName = "department_id")})
    @ManyToOne(optional = false)
    private DepartmentEntity departmentEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<SubjectTeacherEntity> subjectTeacherEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<TimeTableEntity> timeTableEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<ClassScheduleEntity> classScheduleEntityList;

    public TeacherEntity() {
    }

    public TeacherEntity(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @XmlTransient
    public List<SubjectTeacherEntity> getSubjectTeacherEntityList() {
        return subjectTeacherEntityList;
    }

    public void setSubjectTeacherEntityList(List<SubjectTeacherEntity> subjectTeacherEntityList) {
        this.subjectTeacherEntityList = subjectTeacherEntityList;
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
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherEntity)) {
            return false;
        }
        TeacherEntity other = (TeacherEntity) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.TeacherEntity[ teacherId=" + teacherId + " ]";
    }
    
}
