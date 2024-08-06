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
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectEntity.findAll", query = "SELECT s FROM SubjectEntity s"),
    @NamedQuery(name = "SubjectEntity.findBySubjectId", query = "SELECT s FROM SubjectEntity s WHERE s.subjectId = :subjectId"),
    @NamedQuery(name = "SubjectEntity.findBySubjectName", query = "SELECT s FROM SubjectEntity s WHERE s.subjectName = :subjectName")})
public class SubjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subject_id")
    private Integer subjectId;
    @Size(max = 45)
    @Column(name = "subject_name")
    private String subjectName;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private DepartmentEntity departmentId;
    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    @ManyToOne(optional = false)
    private SemesterEntity semesterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<SubjectTeacherEntity> subjectTeacherEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<TimeTableEntity> timeTableEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<ClassScheduleEntity> classScheduleEntityList;

    public SubjectEntity() {
    }

    public SubjectEntity(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public DepartmentEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentEntity departmentId) {
        this.departmentId = departmentId;
    }

    public SemesterEntity getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(SemesterEntity semesterId) {
        this.semesterId = semesterId;
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
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectEntity)) {
            return false;
        }
        SubjectEntity other = (SubjectEntity) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csworkshop.admissionmanagment.entity.SubjectEntity[ subjectId=" + subjectId + " ]";
    }
    
}
